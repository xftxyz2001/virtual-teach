package com.example.myapplication;

import java.util.HashMap;
import java.util.Map;

public class store {
    private static final Map<String, Object> data = new HashMap();

    public static void set(String k, Object v) {
        data.put(k, v);
    }

    public static <T> T get(String k) {
        return data.get(k);
    }
}
