package com.example.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class course_management extends AppCompatActivity {
    private List<course> data = new ArrayList();
    private List<teacher_course> data_1 = new ArrayList();
    private UserDBHelper mHelper;
    String user_name;

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mHelper.close();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_course_management);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(getFilesDir() + "/virtual_teach_research_section.db", 0, (SQLiteDatabase.CursorFactory) null);
        UserDBHelper instance = UserDBHelper.getInstance(this, 1);
        this.mHelper = instance;
        instance.openWrite();
        this.mHelper.openRead();
        Intent intent = getIntent();
        if (intent != null) {
            this.user_name = intent.getStringExtra("user_name");
        } else {
            this.user_name = "";
        }
        this.data_1 = this.mHelper.query_teacher_course(String.format("user_name='%s'", new Object[]{this.user_name}));
        for (int i = 0; i < this.data_1.size(); i++) {
            String course_id = this.data_1.get(i).getCourse_id();
            String course_name = this.mHelper.query_course(String.format("course_id='%s'", new Object[]{course_id})).get(0).getCourse_name();
            String teacher_name = this.mHelper.query_teacher(String.format("user_name='%s'", new Object[]{this.user_name})).get(0).getTeacher_name();
            course c = new course();
            c.setCourse_name(course_name);
            c.setTeacher_name(teacher_name);
            this.data.add(c);
        }
        ((ListView) findViewById(R.id.lv_my_course)).setAdapter(new MyAdapterCourse(this.data, this));
    }

    public void back_to_mine(View view) {
        Intent intent = new Intent();
        intent.setClass(this, Main_Page.class);
        Bundle bundle = new Bundle();
        bundle.putString("user_name", this.user_name);
        bundle.putInt("bid", 2);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
