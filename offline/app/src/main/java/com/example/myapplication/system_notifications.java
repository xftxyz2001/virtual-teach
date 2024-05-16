package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class system_notifications extends AppCompatActivity {
    private List<system_information> data = new ArrayList();
    private UserDBHelper mHelper;
    /* access modifiers changed from: private */
    public List<notification> query_notification = new ArrayList();
    String user_name;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_system_notifications);
        this.user_name = getIntent().getStringExtra("user_name");
        UserDBHelper instance = UserDBHelper.getInstance(this, 1);
        this.mHelper = instance;
        instance.openRead();
        this.mHelper.openWrite();
        this.query_notification = this.mHelper.query_system_notification();
        for (int i = 0; i < this.query_notification.size(); i++) {
            system_information sys = new system_information();
            sys.setDate(this.query_notification.get(i).getDate());
            sys.setInformation_type(this.query_notification.get(i).getNotification_type());
            sys.setInformation_topic(this.query_notification.get(i).getTopic());
            this.data.add(sys);
        }
        ListView lv_system_notification = (ListView) findViewById(R.id.lv_system_notification);
        lv_system_notification.setAdapter(new MyAdapterSystemInformation(this.data, this));
        lv_system_notification.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle((CharSequence) "系统通知");
                builder.setMessage((CharSequence) ((notification) system_notifications.this.query_notification.get(position)).getContent());
                builder.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.create().show();
            }
        });
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
