package com.xftxyz.virtualteach.client.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.xftxyz.virtualteach.client.R;
import com.xftxyz.virtualteach.client.adapter.CourseAdapter;
import com.xftxyz.virtualteach.client.domain.Course;
import com.xftxyz.virtualteach.client.util.OkHttpManager;
import com.xftxyz.virtualteach.client.util.ResultHandler;

import org.json.JSONArray;

import java.util.List;

public class CourseActivity extends AppCompatActivity {

    private ListView lvCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_course);

        initWidgets();
        fetchCourse();
        initListeners();
    }

    private void initListeners() {
        lvCourse.setOnItemClickListener((parent, view, position, id) -> {
            Course course = (Course) parent.getItemAtPosition(position);
            new AlertDialog.Builder(view.getContext())
                    .setTitle("课程详情")
                    .setMessage(course.getIntroduction())
                    .setPositiveButton("确定", null)
                    .show();
        });
    }

    private void fetchCourse() {
        OkHttpManager.get("/api/course/teached", null, new ResultHandler(this) {
            @Override
            public void onSuccess(Object data) throws Exception {
                JSONArray courseArray = (JSONArray) data;
                List<Course> courseList = Course.parseCourseArray(courseArray);
                lvCourse.setAdapter(new CourseAdapter(CourseActivity.this, courseList));
            }
        });
    }

    private void initWidgets() {
        lvCourse = findViewById(R.id.lv_my_course);
    }
}