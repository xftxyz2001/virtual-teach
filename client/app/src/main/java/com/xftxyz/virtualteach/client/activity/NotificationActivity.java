package com.xftxyz.virtualteach.client.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.xftxyz.virtualteach.client.R;

public class NotificationActivity extends AppCompatActivity {

    private ListView lvNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notification);

        initWidgets();
    }

    private void initWidgets() {
        lvNotification = findViewById(R.id.lv_notification);
    }
}