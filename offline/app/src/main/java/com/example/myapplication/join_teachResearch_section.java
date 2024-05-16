package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class join_teachResearch_section extends AppCompatActivity {
    private UserDBHelper mHelper;
    private List<section_user> result;
    /* access modifiers changed from: private */
    public String user_name;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_join_teach_research_section);
        this.user_name = getIntent().getStringExtra("user_name");
        UserDBHelper instance = UserDBHelper.getInstance(this, 1);
        this.mHelper = instance;
        instance.openRead();
        this.mHelper.openWrite();
    }

    public void apply_to_join(View view) {
        EditText ed_user = (EditText) findViewById(R.id.join_teacher_num);
        EditText ed_name = (EditText) findViewById(R.id.join_teacher_name);
        EditText ed_section = (EditText) findViewById(R.id.join_section_num);
        System.out.println(ed_user.getText().toString());
        System.out.println(this.user_name);
        if (ed_user.getText().toString().equals("") || ed_name.getText().toString().equals("") || ed_section.getText().toString().equals("")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle((CharSequence) "加入虚拟教研室");
            builder.setMessage((CharSequence) "您输入的信息不完整");
            builder.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder.create().show();
        } else if (!this.user_name.equals(ed_user.getText().toString())) {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
            builder2.setTitle((CharSequence) "加入虚拟教研室");
            builder2.setMessage((CharSequence) "您输入的教职工号有误");
            builder2.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder2.create().show();
        } else if (exist_section(ed_section.getText().toString())) {
            AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
            builder3.setTitle((CharSequence) "加入虚拟教研室");
            builder3.setMessage((CharSequence) "教研室已经存在");
            builder3.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder3.create().show();
        } else {
            ArrayList<section_user> lst = new ArrayList<>();
            section_user section_user = new section_user();
            section_user.setUser_name(this.user_name);
            section_user.setId(ed_section.getText().toString());
            lst.add(section_user);
            this.mHelper.insert_section_user(lst);
            AlertDialog.Builder builder4 = new AlertDialog.Builder(this);
            builder4.setTitle((CharSequence) "加入虚拟教研室");
            builder4.setMessage((CharSequence) "教研室添加成功");
            builder4.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(join_teachResearch_section.this, virtual_teachResearch_section.class);
                    intent.putExtra("user_name", join_teachResearch_section.this.user_name);
                    join_teachResearch_section.this.startActivity(intent);
                }
            });
            builder4.create().show();
        }
    }

    private boolean exist_section(String section) {
        List<section_user> query_section_user = this.mHelper.query_section_user(String.format("user_name = %s", new Object[]{this.user_name}));
        this.result = query_section_user;
        if (query_section_user == null || query_section_user.size() < 1) {
            return false;
        }
        for (section_user section_user : this.result) {
            if (section_user.getId().equals(section)) {
                return true;
            }
        }
        return false;
    }
}
