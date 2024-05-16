package com.xftxyz.virtualteach.client.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.xftxyz.virtualteach.client.R;

public class CreateSectionActivity extends AppCompatActivity {

    private EditText etSectionName;
    private Spinner spCourseSelector;
    private Button btnCreateSectionNextStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_section);

        initWidgets();
        initListeners();
    }

    private void initListeners() {
        btnCreateSectionNextStep.setOnClickListener(v -> {
            String sectionName = etSectionName.getText().toString();
            String courseName = spCourseSelector.getSelectedItem().toString();

        });
    }

    private void initWidgets() {
        etSectionName = findViewById(R.id.et_section_name);
        spCourseSelector = findViewById(R.id.sp_course_selector);
        btnCreateSectionNextStep = findViewById(R.id.btn_create_section_next_step);
    }
}