package com.xftxyz.virtualteach.client;

import android.app.Application;

import com.xftxyz.virtualteach.client.util.ContextHolder;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ContextHolder.init(this);
    }
}
