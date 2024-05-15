package com.xftxyz.virtualteach.client.util;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreferences {

    private static final String USER_PREFERENCES = "user";
    private static final String TOKEN = "token";

    // 获取token
    public static String getToken(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE);
        return preferences.getString(TOKEN, "");
    }

    // 保存token
    public static void saveToken(Context context, String token) {
        SharedPreferences preferences = context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TOKEN, token);
        editor.apply();
    }
}
