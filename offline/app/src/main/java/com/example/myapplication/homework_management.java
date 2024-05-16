package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class homework_management extends AppCompatActivity {
    private UserDBHelper mHelper;
    private List<news> news_result = new ArrayList();
    private List<section> result = new ArrayList();
    private String user_name;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_homework_management);
        this.user_name = (String) store.get("user_name");
        UserDBHelper instance = UserDBHelper.getInstance(this, 1);
        this.mHelper = instance;
        instance.openWrite();
        this.mHelper.openRead();
        this.result = this.mHelper.query_teach_and_research_section(String.format("group_leader_user_name='%s'", new Object[]{this.user_name}));
        List<news> news = this.mHelper.query_news();
        for (section section : this.result) {
            String section_name = section.getName();
            for (news news1 : news) {
                if (news1.getPublisher().equals(section_name)) {
                    this.news_result.add(news1);
                }
            }
        }
        ListView lv_my_course = (ListView) findViewById(R.id.lv_my_publish);
        List<news_list> news_list1 = new ArrayList<>();
        for (news news12 : this.news_result) {
            news_list news_list2 = new news_list();
            news_list2.setNews_date(news12.getDate());
            news_list2.setNews_topic(news12.getTopic());
            news_list1.add(news_list2);
        }
        lv_my_course.setAdapter(new MyNewsListAdapter(news_list1, this));
    }

    public void back_to_mine(View view) {
        Intent intent = new Intent();
        intent.setClass(this, Main_Page.class);
        Bundle bundle = new Bundle();
        bundle.putString("user_name", (String) store.get("user_name"));
        bundle.putInt("bid", 2);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
