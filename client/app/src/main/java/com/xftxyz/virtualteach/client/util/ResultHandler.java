package com.xftxyz.virtualteach.client.util;

import org.json.JSONObject;

public interface ResultHandler {
    void onSuccess(JSONObject result);

    void onFail(String message);
}
