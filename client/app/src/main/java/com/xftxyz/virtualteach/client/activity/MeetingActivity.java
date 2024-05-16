package com.xftxyz.virtualteach.client.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.xftxyz.virtualteach.client.R;

public class MeetingActivity extends AppCompatActivity {

    private Button btnMeetingAdd;
    private ListView lvMeeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_meeting);

        initWidgets();
    }

    private void initWidgets() {
        btnMeetingAdd = findViewById(R.id.btn_meeting_add);
        lvMeeting = findViewById(R.id.lv_meeting);
    }
}