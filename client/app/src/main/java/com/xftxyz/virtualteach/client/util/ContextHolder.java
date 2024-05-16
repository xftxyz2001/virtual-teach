package com.xftxyz.virtualteach.client.util;

import android.content.Context;

public class ContextHolder {
    private static Context sContext;

    private ContextHolder() {
    } // 私有构造函数防止实例化

    public static void init(Context context) {
        if (sContext == null) {
            sContext = context.getApplicationContext(); // 使用Application Context防止内存泄漏
        }
    }

    public static Context getContext() {
        if (sContext == null) {
            throw new IllegalStateException("ContextHolder not initialized. Call init() first.");
        }
        return sContext;
    }
}
