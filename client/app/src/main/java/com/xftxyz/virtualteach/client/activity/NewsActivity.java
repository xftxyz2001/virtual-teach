package com.xftxyz.virtualteach.client.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.xftxyz.virtualteach.client.R;
import com.xftxyz.virtualteach.client.adapter.NewsAdapter;
import com.xftxyz.virtualteach.client.util.OkHttpManager;
import com.xftxyz.virtualteach.client.util.ResultHandler;

import org.json.JSONObject;

public class NewsActivity extends AppCompatActivity {

    private ListView lvNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news);

        initWidgets();
        fetchNews();
    }

    private void fetchNews() {
        OkHttpManager.get("/api/news/list", null, new ResultHandler() {
            @Override
            public void onSuccess(JSONObject data) throws Exception {

            }

            @Override
            public void onFailed(Integer code, String message) {

            }

            @Override
            public void onError(Throwable t) {

            }
        });
//        lvNews.setAdapter(new NewsAdapter());
    }

    private void initWidgets() {
        lvNews = findViewById(R.id.lv_news);
    }
}