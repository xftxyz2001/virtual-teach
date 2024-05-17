package com.xftxyz.virtualteach.client.util;

import android.content.Context;

public class UserPreferences {

    private static final String USER_PREFERENCES = "user";
    private static final String TOKEN = "token";

    // 获取token
    public static String getToken() {
        return ContextHolder.getContext()
                .getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE)
                .getString(TOKEN, "");
    }

    // 保存token
    public static void saveToken(String token) {
        ContextHolder.getContext()
                .getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE)
                .edit()
                .putString(TOKEN, token)
                .apply();
    }
}
