package com.xftxyz.virtualteach.config;

public interface Env {

    // 请求域中的用户id
    String USER_ID = "userId";

    // 短信验证码 Redis key 前缀
    String SMS_VERIFICATION_CODE_REDIS_KEY_PREFIX = "sms_verification_code_"; // +手机号
    // 短信验证码 Redis key 过期时间（秒）
    long SMS_VERIFICATION_CODE_REDIS_KEY_EXPIRE = 300L; // 5分钟
    // 验证码请求间隔时间（秒）
    long SMS_VERIFICATION_CODE_REQUEST_INTERVAL = 60L; // 1分钟
    // 短信验证码位数
    int SMS_VERIFICATION_CODE_LENGTH = 6;
}
