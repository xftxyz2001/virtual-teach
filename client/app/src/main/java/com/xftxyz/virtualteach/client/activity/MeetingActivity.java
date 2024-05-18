package com.xftxyz.virtualteach.client.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.xftxyz.virtualteach.client.R;
import com.xftxyz.virtualteach.client.adapter.MeetingAdapter;
import com.xftxyz.virtualteach.client.domain.Meeting;
import com.xftxyz.virtualteach.client.util.OkHttpManager;
import com.xftxyz.virtualteach.client.util.ResultHandler;

import org.json.JSONArray;

import java.util.List;

public class MeetingActivity extends AppCompatActivity {

    private Button btnMeetingAdd;
    private ListView lvMeeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_meeting);

        initWidgets();
        fetchMeetings();
        initListeners();
    }

    private void initListeners() {
        btnMeetingAdd.setOnClickListener(v -> {

        });
        lvMeeting.setOnItemClickListener((parent, view, position, id) -> {
            Meeting meeting = (Meeting) parent.getItemAtPosition(position);
            new AlertDialog.Builder(view.getContext())
                    .setTitle("会议详情")
                    .setMessage(meeting.getInviteNum())
                    .setPositiveButton("确定", null)
                    .show();
        });
    }

    private void fetchMeetings() {
        OkHttpManager.get("/api/meeting/list", null, new ResultHandler(this) {
            @Override
            public void onSuccess(Object data) throws Exception {
                JSONArray meetingArray = (JSONArray) data;
                List<Meeting> meetingList = Meeting.parseMeetingArray(meetingArray);
                lvMeeting.setAdapter(new MeetingAdapter(MeetingActivity.this, meetingList));
            }
        });
    }

    private void initWidgets() {
        btnMeetingAdd = findViewById(R.id.btn_meeting_add);
        lvMeeting = findViewById(R.id.lv_meeting);
    }
}