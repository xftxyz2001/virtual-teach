package com.xftxyz.virtualteach.client.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.xftxyz.virtualteach.client.R;

public class CourseActivity extends AppCompatActivity {

    private ListView lvCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_course);

        initWidgets();
    }

    private void initWidgets() {
        lvCourse = findViewById(R.id.lv_my_course);
    }
}