package com.xftxyz.virtualteach.client.util;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpManager {

    private static final String BASE_URL = "http://10.0.2.2:8080";
    private static final long DEFAULT_TIMEOUT = 10; // 默认超时时间10秒

    private static OkHttpClient client;
    private static final Gson GSON = new Gson();
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    // 拦截器
    private static final Interceptor TOKEN_INTERCEPTOR = new Interceptor() {
        @NonNull
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request requestWithToken = originalRequest.newBuilder()
                    .addHeader("Authorization", getToken())
                    .build();
            return chain.proceed(requestWithToken);
        }

        private String getToken() {
            return UserPreferences.getToken();
        }
    };

    // 结果处理
    private static class MyCallback implements Callback {
        private final ResultHandler handler;

        public MyCallback(ResultHandler handler) {
            this.handler = handler;
        }

        @Override
        public void onFailure(@NonNull Call call, @NonNull IOException e) {
            if (handler == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(() -> handler.onError(e));
        }

        @Override
        public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
            if (handler == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(() -> {
                try {
                    if (!response.isSuccessful()) {
                        handler.onFailed(response.code(), response.message());
                        return;
                    }
                    String result = response.body().string();
                    JSONObject resultJSON = new JSONObject(result);
                    if (resultJSON.getInt("code") != 0) {
                        handler.onFailed(resultJSON.getInt("code"), resultJSON.getString("message"));
                        return;
                    }
                    handler.onSuccess(resultJSON.getJSONObject("data"));
                } catch (Exception e) {
                    handler.onError(e);
                }
            });
        }
    }

    private OkHttpManager() {
    }

    public static OkHttpClient getClient() {
        if (client != null) {
            return client;
        }
        synchronized (OkHttpManager.class) {
            if (client == null) {
                client = new OkHttpClient.Builder()
                        .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .addInterceptor(TOKEN_INTERCEPTOR)
                        .build();
            }
        }
        return client;
    }

    public static void get(String url, Map<String, String> params, ResultHandler handler) {
        // 处理url
        if (params != null && !params.isEmpty()) {
            StringBuilder urlBuilder = new StringBuilder(url);
            urlBuilder.append("?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            url = urlBuilder.substring(0, urlBuilder.length() - 1);
        }
        Request request = new Request.Builder()
                .url(BASE_URL + url)
                .build();
        getClient().newCall(request).enqueue(new MyCallback(handler));
    }

    public static void post(String url, Map<String, Object> data, ResultHandler handler) {
        RequestBody requestBody = RequestBody.create(JSON, GSON.toJson(data));
        Request request = new Request.Builder()
                .url(BASE_URL + url)
                .post(requestBody)
                .build();
        getClient().newCall(request).enqueue(new MyCallback(handler));
    }
}
