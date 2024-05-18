package com.xftxyz.virtualteach.client.util;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

public abstract class ResultHandler {

    private Context context;

    public ResultHandler(Context context) {
        this.context = context;
    }

    public abstract void onSuccess(Object data) throws Exception; // res.data

    public void onFailed(Integer code, String message) {
        new AlertDialog.Builder(context)
                .setTitle("错误")
                .setMessage("状态码：" + code + "\n" + message)
                .setPositiveButton("确定", null)
                .show();
    }

    public void onError(Throwable t) {
        new AlertDialog.Builder(context)
                .setTitle("错误")
                .setMessage(t.getMessage())
                .setPositiveButton("确定", null)
                .show();
    }
}
