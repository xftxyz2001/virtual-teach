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

public class news_announcement extends AppCompatActivity {
    private List<news_list> data = new ArrayList();
    private UserDBHelper mHelper;
    /* access modifiers changed from: private */
    public List<news> query_news = new ArrayList();
    String user_name;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_news_announcement);
        this.user_name = getIntent().getStringExtra("user_name");
        UserDBHelper instance = UserDBHelper.getInstance(this, 1);
        this.mHelper = instance;
        instance.openRead();
        this.mHelper.openWrite();
        this.query_news = this.mHelper.query_news();
        for (int i = 0; i < this.query_news.size(); i++) {
            news_list news = new news_list();
            news.setNews_topic(this.query_news.get(i).getTopic());
            news.setNews_date(this.query_news.get(i).getDate());
            this.data.add(news);
        }
        ListView lv_news = (ListView) findViewById(R.id.lv_news);
        lv_news.setAdapter(new MyNewsListAdapter(this.data, this));
        lv_news.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle((CharSequence) "新闻公告");
                builder.setMessage((CharSequence) ((news) news_announcement.this.query_news.get(position)).getContent());
                builder.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.create().show();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mHelper.close();
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
