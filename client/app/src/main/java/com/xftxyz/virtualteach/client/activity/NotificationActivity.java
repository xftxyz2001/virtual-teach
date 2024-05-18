package com.xftxyz.virtualteach.client.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.xftxyz.virtualteach.client.R;
import com.xftxyz.virtualteach.client.adapter.NotificationAdapter;
import com.xftxyz.virtualteach.client.domain.SystemNotification;
import com.xftxyz.virtualteach.client.util.OkHttpManager;
import com.xftxyz.virtualteach.client.util.ResultHandler;

import org.json.JSONArray;

import java.util.List;

public class NotificationActivity extends AppCompatActivity {

    private ListView lvNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notification);

        initWidgets();
        fetchNotification();
        initListeners();
    }

    private void initListeners() {
        lvNotification.setOnItemClickListener((parent, view, position, id) -> {
            SystemNotification notification = (SystemNotification) parent.getItemAtPosition(position);
            new AlertDialog.Builder(view.getContext())
                    .setTitle("系统通知")
                    .setMessage(notification.getContent())
                    .setPositiveButton("确定", null)
                    .show();
        });
    }

    private void fetchNotification() {
        OkHttpManager.get("/api/notification/list", null, new ResultHandler(this) {
            @Override
            public void onSuccess(Object data) throws Exception {
                JSONArray notificationArray = (JSONArray) data;
                List<SystemNotification> notificationList = SystemNotification.parseSystemNotificationArray(notificationArray);
                lvNotification.setAdapter(new NotificationAdapter(NotificationActivity.this, notificationList));
            }
        });
    }

    private void initWidgets() {
        lvNotification = findViewById(R.id.lv_notification);
    }
}