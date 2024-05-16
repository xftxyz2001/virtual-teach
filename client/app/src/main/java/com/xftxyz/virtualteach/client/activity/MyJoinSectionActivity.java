package com.xftxyz.virtualteach.client.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.xftxyz.virtualteach.client.R;

public class MyJoinSectionActivity extends AppCompatActivity {

    private ListView lvMyJoinSection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_join_section);

        initWidgets();
    }

    private void initWidgets() {
        lvMyJoinSection = findViewById(R.id.lv_my_join_section);
    }
}