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


public class MyJoinSection extends AppCompatActivity {
    private List<teach_and_research_section> data = new ArrayList();
    /* access modifiers changed from: private */
    public UserDBHelper mHelper;
    /* access modifiers changed from: private */
    public List<section> query_section = new ArrayList();
    /* access modifiers changed from: private */
    public List<section_user> query_section_user = new ArrayList();
    String user_name;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_my_join_section);
        this.user_name = getIntent().getStringExtra("user_name");
        UserDBHelper instance = UserDBHelper.getInstance(this, 1);
        this.mHelper = instance;
        instance.openRead();
        this.mHelper.openWrite();
        this.query_section_user = this.mHelper.query_section_user(String.format("user_name = %s", new Object[]{this.user_name}));
        for (int i = 0; i < this.query_section_user.size(); i++) {
            teach_and_research_section t = new teach_and_research_section();
            List<section> q = this.mHelper.query_teach_and_research_section(String.format("id = %s", new Object[]{this.query_section_user.get(i).getId()}));
            t.setCourse_name(q.get(0).getName());
            t.setSection_leader(q.get(0).getGroup_leader());
            t.setSection_num(String.format("教研室编码：%s", new Object[]{q.get(0).getId()}));
            this.data.add(t);
        }
        ListView lv_my_join_section = (ListView) findViewById(R.id.lv_my_join_section);
        lv_my_join_section.setAdapter(new MyAdapterTeachResearchSection(this.data, this));
        lv_my_join_section.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                MyJoinSection myJoinSection = MyJoinSection.this;
                List unused = myJoinSection.query_section = myJoinSection.mHelper.query_teach_and_research_section(String.format("id = %s", new Object[]{((section_user) MyJoinSection.this.query_section_user.get(position)).getId()}));
                builder.setTitle((CharSequence) "教研室");
                builder.setMessage((CharSequence) "教研室id: " + ((section) MyJoinSection.this.query_section.get(0)).getId() + "\n教研室名称: " + ((section) MyJoinSection.this.query_section.get(0)).getName() + "\n教研室创建者用户名: " + ((section) MyJoinSection.this.query_section.get(0)).getGroup_leader() + "\n教研课程id: " + ((section) MyJoinSection.this.query_section.get(0)).getCourse_id() + "\n教研室所属学院: " + ((section) MyJoinSection.this.query_section.get(0)).getDepartment());
                builder.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.create().show();
            }
        });
    }

    public void back_to_virtual(View view) {
        Intent intent = new Intent(this, virtual_teachResearch_section.class);
        intent.putExtra("user_name", this.user_name);
        startActivity(intent);
    }
}
