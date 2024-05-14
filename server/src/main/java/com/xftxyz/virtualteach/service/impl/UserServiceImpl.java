package com.xftxyz.virtualteach.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.virtualteach.domain.User;
import com.xftxyz.virtualteach.exception.BusinessException;
import com.xftxyz.virtualteach.helper.JwtHelper;
import com.xftxyz.virtualteach.mapper.UserMapper;
import com.xftxyz.virtualteach.result.ResultEnum;
import com.xftxyz.virtualteach.service.UserService;
import com.xftxyz.virtualteach.vo.req.LoginReq;
import com.xftxyz.virtualteach.vo.resp.LoginResp;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author 25810
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2024-05-13 14:37:33
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

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
}




