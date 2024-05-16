package com.xftxyz.virtualteach.client.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.xftxyz.virtualteach.client.R;

public class NewsActivity extends AppCompatActivity {

    private ListView lvNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news);

        initWidgets();
    }

    private void initWidgets() {
        lvNews = findViewById(R.id.lv_news);
    }
}