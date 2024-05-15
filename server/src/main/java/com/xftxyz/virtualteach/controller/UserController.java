package com.xftxyz.virtualteach.controller;

import com.xftxyz.virtualteach.config.Env;
import com.xftxyz.virtualteach.service.UserService;
import com.xftxyz.virtualteach.vo.req.*;
import com.xftxyz.virtualteach.vo.resp.LoginResp;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    // 登录
    @PostMapping("/login")
    public LoginResp login(@RequestBody @NotNull LoginReq loginReq) {
        return userService.login(loginReq);
    }

    // 忘记密码
    @PostMapping("/forgetPassword")
    public Boolean forgetPassword(@RequestBody @NotNull ForgetPasswordReq forgetPasswordReq) {
        return userService.forgetPassword(forgetPasswordReq);
    }

    // 发送验证码
    @PostMapping("/sendCode")
    public Boolean sendCode(@RequestBody @NotNull SendCodeReq sendCodeReq) {
        return userService.sendCode(sendCodeReq);
    }

    // 修改手机号
    @PostMapping("/updatePhone")
    public Boolean updatePhone(@RequestAttribute(Env.USER_ID) Long userId,
                               @RequestBody @NotNull UpdatePhoneReq updatePhoneReq) {
        return userService.updatePhone(userId, updatePhoneReq);
    }

    // 修改个性签名
    @PostMapping("/updateSignature")
    public Boolean updateSignature(@RequestAttribute(Env.USER_ID) Long userId,
                                   @RequestBody @NotNull UpdateSignatureReq updateSignatureReq) {
        return userService.updateSignature(userId, updateSignatureReq);
    }
}
