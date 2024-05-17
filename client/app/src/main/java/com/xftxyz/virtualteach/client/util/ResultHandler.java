package com.xftxyz.virtualteach.client.util;

import org.json.JSONObject;

public interface ResultHandler {
    void onSuccess(JSONObject data) throws Exception; // res.data

    void onFailed(Integer code, String message); // res.code, res.message

    void onError(Throwable t);
}
