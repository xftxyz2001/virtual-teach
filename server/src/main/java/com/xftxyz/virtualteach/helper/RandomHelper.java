package com.xftxyz.virtualteach.helper;

import com.xftxyz.virtualteach.config.Env;

import java.util.Random;

public class RandomHelper {

    private static final Random random = new Random();

    public static String generateVerificationCode() {
        // 生成验证码
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < Env.SMS_VERIFICATION_CODE_LENGTH; i++) {
            code.append(random.nextInt(10));
        }
        return code.toString();
    }
}
