package com.xftxyz.virtualteach.controller;

import com.xftxyz.virtualteach.service.UserService;
import com.xftxyz.virtualteach.vo.req.ForgetPasswordReq;
import com.xftxyz.virtualteach.vo.req.LoginReq;
import com.xftxyz.virtualteach.vo.req.SendCodeReq;
import com.xftxyz.virtualteach.vo.resp.LoginResp;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}