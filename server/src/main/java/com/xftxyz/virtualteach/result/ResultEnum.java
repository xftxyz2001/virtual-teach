package com.xftxyz.virtualteach.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultEnum {

    // 通用
    FAILED(-1, "失败"), // 失败
    SUCCESS(0, "成功"), // 成功

    LOGIN_ERROR(100, "登录失败，请检查用户名和密码"), // 登录失败
    NOT_LOGIN(101, "未登录"), // 未登录
    PASSWORD_ERROR(102, "密码错误"), // 密码错误
    USER_NOT_EXIST(103, "用户不存在"), // 用户不存在
    PHONE_ALREADY_EXIST(104, "手机号已存在"), // 手机号已存在

    USER_ALREADY_JOINED_SECTION(301, "用户已加入教研室"), // 用户已加入教研室
    COURSE_NOT_EXIST(302, "课程不存在"), // 课程不存在

    // 4参数错误
    PARAM_ERROR(400, "非法参数"),
    PARAM_VALID_ERROR(401, "参数校验失败"),

    // 5短信相关
    SMS_VERIFICATION_CODE_SEND_FAILED(501, "短信验证码发送失败"),
    SMS_VERIFICATION_CODE_REQUEST_TOO_FREQUENT(502, "请求验证码过于频繁"),
    SMS_VERIFICATION_CODE_EXPIRED(503, "验证码失效"),
    SMS_VERIFICATION_CODE_ERROR(504, "验证码错误"),
    ;


    private final Integer code;
    private final String message;

}
