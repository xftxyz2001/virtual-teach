package com.xftxyz.virtualteach.service.impl;

import com.aliyun.sdk.service.dysmsapi20170525.AsyncClient;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponse;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.virtualteach.autoconfigure.SmsProperties;
import com.xftxyz.virtualteach.config.Env;
import com.xftxyz.virtualteach.domain.User;
import com.xftxyz.virtualteach.exception.BusinessException;
import com.xftxyz.virtualteach.helper.JwtHelper;
import com.xftxyz.virtualteach.helper.RandomHelper;
import com.xftxyz.virtualteach.mapper.UserMapper;
import com.xftxyz.virtualteach.result.ResultEnum;
import com.xftxyz.virtualteach.service.UserService;
import com.xftxyz.virtualteach.vo.req.ForgetPasswordReq;
import com.xftxyz.virtualteach.vo.req.LoginReq;
import com.xftxyz.virtualteach.vo.req.SendCodeReq;
import com.xftxyz.virtualteach.vo.resp.LoginResp;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author 25810
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2024-05-13 14:37:33
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    private final StringRedisTemplate stringRedisTemplate;
    private final SmsProperties smsProperties;
    private final AsyncClient client;

    @Override
    public LoginResp login(LoginReq loginReq) {
        User user = baseMapper.selectOne(Wrappers.<User>lambdaQuery()
                .eq(User::getLogin, loginReq.getLogin())
                .eq(User::getPassword, loginReq.getPassword()));
        if (ObjectUtils.isEmpty(user)) {
            BusinessException.throwOf(ResultEnum.LOGIN_ERROR);
        }
        return LoginResp.builder().token(JwtHelper.generateToken(user.getId())).build();
    }

    @Override
    public Boolean sendCode(SendCodeReq sendCodeReq) {
        String phoneNumber = sendCodeReq.getPhone();

        User user = baseMapper.selectOne(Wrappers.<User>lambdaQuery()
                .eq(User::getLogin, phoneNumber));
        if (ObjectUtils.isEmpty(user)) {
            BusinessException.throwOf(ResultEnum.USER_NOT_EXIST);
        }
        String redisKey = Env.SMS_VERIFICATION_CODE_REDIS_KEY_PREFIX + phoneNumber;
        if (Boolean.TRUE.equals(stringRedisTemplate.hasKey(redisKey))) {
            // 获取key剩余时间
            Long expire = stringRedisTemplate.getExpire(redisKey, TimeUnit.SECONDS);
            if (!ObjectUtils.isEmpty(expire)) {
                // 获取剩余等待时间
                long waitTime = Env.SMS_VERIFICATION_CODE_REQUEST_INTERVAL
                                - (Env.SMS_VERIFICATION_CODE_REDIS_KEY_EXPIRE - expire);
                if (waitTime > 0) {
                    BusinessException.throwOf(ResultEnum.SMS_VERIFICATION_CODE_REQUEST_TOO_FREQUENT);
                }
            }
        }
        // 生成验证码
        String code = RandomHelper.generateVerificationCode();
        // 存储验证码
        stringRedisTemplate.opsForValue().set(Env.SMS_VERIFICATION_CODE_REDIS_KEY_PREFIX + phoneNumber, code,
                Env.SMS_VERIFICATION_CODE_REDIS_KEY_EXPIRE, TimeUnit.SECONDS);
        // 发送验证码
        SendSmsRequest sendSmsRequest = SendSmsRequest.builder()
                .phoneNumbers(phoneNumber)
                .signName(smsProperties.getSignName())
                .templateCode(smsProperties.getCode())
                .templateParam("{\"code\":\"" + code + "\"}")
                .build();

        CompletableFuture<SendSmsResponse> response = client.sendSms(sendSmsRequest);
        SendSmsResponse resp = null;
        try {
            resp = response.get();
        } catch (Exception e) {
            BusinessException.throwOf(ResultEnum.SMS_VERIFICATION_CODE_SEND_FAILED);
        }
        if (!"OK".equals(resp.getBody().getCode())) {
            BusinessException.throwOf(ResultEnum.SMS_VERIFICATION_CODE_SEND_FAILED);
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean forgetPassword(ForgetPasswordReq forgetPasswordReq) {
        String login = forgetPasswordReq.getLogin();
        User user = baseMapper.selectOne(Wrappers.<User>lambdaQuery()
                .eq(User::getLogin, login));
        if (ObjectUtils.isEmpty(user)) {
            BusinessException.throwOf(ResultEnum.USER_NOT_EXIST);
        }
        checkVerificationCode(login, forgetPasswordReq.getCode());
        user.setPassword(forgetPasswordReq.getPassword());
        baseMapper.updateById(user);
        return Boolean.TRUE;
    }

    private void checkVerificationCode(String phoneNumber, String verificationCode) {
        // 检查验证码
        // Redis对应的key
        String redisKey = Env.SMS_VERIFICATION_CODE_REDIS_KEY_PREFIX + phoneNumber;
        if (Boolean.FALSE.equals(stringRedisTemplate.hasKey(redisKey))) {
            BusinessException.throwOf(ResultEnum.SMS_VERIFICATION_CODE_EXPIRED);
        }
        String redisCode = stringRedisTemplate.opsForValue().get(redisKey);
        if (!verificationCode.equals(redisCode)) {
            BusinessException.throwOf(ResultEnum.SMS_VERIFICATION_CODE_ERROR);
        }
        // 删除验证码
        stringRedisTemplate.delete(redisKey);
    }
}




