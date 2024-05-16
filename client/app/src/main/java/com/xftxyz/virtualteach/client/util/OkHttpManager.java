package com.xftxyz.virtualteach.client.util;

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
    private static final long DEFAULT_TIMEOUT = 10; // 默认超时时间10秒

    private static OkHttpClient client;
    private static Gson GSON = new Gson();
    private static MediaType JSON = MediaType.get("application/json; charset=utf-8");
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
            return UserPreferences.getToken(ContextHolder.getContext());
        }
    };

    private OkHttpManager() {
    }

    public static OkHttpClient getClient() {
        if (client == null) {
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
                .url(url)
                .build();
        getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                handler.onFail(e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    try {
                        String result = response.body().string();
                        handler.onSuccess(new JSONObject(result));
                    } catch (Exception e) {
                        handler.onFail(e.getMessage());
                    }
                } else {
                    handler.onFail(response.message());
                }
            }
        });
    }

    public static <T> void post(String url, Object data, ResultHandler handler) {
        RequestBody requestBody = RequestBody.create(JSON, GSON.toJson(data));
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                handler.onFail(e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    try {
                        String result = response.body().string();
                        handler.onSuccess(new JSONObject(result));
                    } catch (Exception e) {
                        handler.onFail(e.getMessage());
                    }
                } else {
                    handler.onFail(response.message());
                }
            }
        });
    }
}
