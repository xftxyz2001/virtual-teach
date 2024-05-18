package com.xftxyz.virtualteach.client.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.xftxyz.virtualteach.client.R;
import com.xftxyz.virtualteach.client.adapter.NewsAdapter;
import com.xftxyz.virtualteach.client.domain.News;
import com.xftxyz.virtualteach.client.util.OkHttpManager;
import com.xftxyz.virtualteach.client.util.ResultHandler;

import org.json.JSONArray;

import java.util.List;

public class NewsActivity extends AppCompatActivity {

    private ListView lvNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news);

        initWidgets();
        fetchNews();
        initListeners();
    }

    private void initListeners() {
        lvNews.setOnItemClickListener((parent, view, position, id) -> {
            News news = (News) parent.getItemAtPosition(position);
            new AlertDialog.Builder(view.getContext())
                    .setTitle("新闻公告")
                    .setMessage(news.getContent())
                    .setPositiveButton("确定", null)
                    .show();
        });
    }

    private void fetchNews() {
        OkHttpManager.get("/api/news/list", null, new ResultHandler(this) {
            @Override
            public void onSuccess(Object data) throws Exception {
                JSONArray newsArray = (JSONArray) data;
                List<News> newsList = News.parseNewsArray(newsArray);
                lvNews.setAdapter(new NewsAdapter(NewsActivity.this, newsList));
            }
        });
    }

    private void initWidgets() {
        lvNews = findViewById(R.id.lv_news);
    }
}