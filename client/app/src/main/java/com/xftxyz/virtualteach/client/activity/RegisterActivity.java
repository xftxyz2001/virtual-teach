package com.xftxyz.virtualteach.client.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.xftxyz.virtualteach.client.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText etTeacherNumber;
    private EditText etTeacherName;
    private Spinner spDepartment;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        initWidgets();
        initListeners();
    }

    private void initListeners() {
        btnNext.setOnClickListener(v -> {
            // 下一步
        });
    }

    private void initWidgets() {
        etTeacherNumber = findViewById(R.id.et_register_teacher_num);
        etTeacherName = findViewById(R.id.et_register_name);
        spDepartment = findViewById(R.id.sp_register_department);
        btnNext = findViewById(R.id.btn_register_next_step);
    }
}