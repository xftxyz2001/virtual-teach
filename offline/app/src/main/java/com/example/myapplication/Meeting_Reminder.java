package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Meeting_Reminder extends AppCompatActivity {
    /* access modifiers changed from: private */
    public List<meeting> data = new ArrayList();
    private UserDBHelper mHelper;
    private List<db_meeting> query_meeting = new ArrayList();
    String user_name;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_meeting_reminder);
        this.user_name = getIntent().getStringExtra("user_name");
        UserDBHelper instance = UserDBHelper.getInstance(this, 1);
        this.mHelper = instance;
        instance.openRead();
        this.mHelper.openWrite();
        this.query_meeting = this.mHelper.query_meeting();
        for (int i = 0; i < this.query_meeting.size(); i++) {
            meeting meet = new meeting();
            meet.setMeetingTopic(this.query_meeting.get(i).getMeeting_topic());
            meet.setStartDate(this.query_meeting.get(i).getStart_time());
            meet.setMeetingNum(this.query_meeting.get(i).getInvite_num());
            System.out.println(this.query_meeting.get(i).getMeeting_topic());
            this.data.add(meet);
        }
        ListView lv_meeting = (ListView) findViewById(R.id.lv_meeting);
        lv_meeting.setAdapter(new MyAdapterMeeting(this.data, this));
        lv_meeting.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
                if (dateStr.compareTo(((meeting) Meeting_Reminder.this.data.get(position)).getStartDate()) > 0) {
                    Meeting_Reminder meeting_Reminder = Meeting_Reminder.this;
                    meeting_Reminder.meeting_ended(view, ((meeting) meeting_Reminder.data.get(position)).getMeetingNum());
                } else if (dateStr.equals(((meeting) Meeting_Reminder.this.data.get(position)).getStartDate())) {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse("https://meeting.tencent.com"));
                    Meeting_Reminder.this.startActivity(intent);
                } else {
                    Meeting_Reminder meeting_Reminder2 = Meeting_Reminder.this;
                    meeting_Reminder2.meeting_wait(view, ((meeting) meeting_Reminder2.data.get(position)).getMeetingNum());
                }
            }
        });
    }

    public void meeting_ended(View view, String num) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) "会议已结束");
        builder.setMessage((CharSequence) "无法加入会议，请稍后查看会议记录" + num);
        builder.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.create().show();
    }

    public void meeting_wait(View view, String num) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) "会议未开始");
        builder.setMessage((CharSequence) "无法加入会议，会议尚未开始" + num);
        builder.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.create().show();
    }

    public void back_to_information(View view) {
        Intent intent = new Intent();
        intent.setClass(this, Main_Page.class);
        Bundle bundle = new Bundle();
        bundle.putString("user_name", this.user_name);
        bundle.putInt("bid", 1);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
