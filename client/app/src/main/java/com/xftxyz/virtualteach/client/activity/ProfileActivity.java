package com.xftxyz.virtualteach.client.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.xftxyz.virtualteach.client.R;

public class ProfileActivity extends AppCompatActivity {

    private Button btnAvatar;
    private TextView tvNickName;
    private TextView tvDays;
    private Button btnName;
    private Button btnTeacherNum;
    private Button btnDepartment;
    private Button btnSignature;
    private Button btnTelephone;
    private Button btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        initWidgets();
        initListeners();
    }

    private void initListeners() {
        btnAvatar.setOnClickListener(v -> {

        });
        btnName.setOnClickListener(v -> {

        });
        btnTeacherNum.setOnClickListener(v -> {

        });
        btnDepartment.setOnClickListener(v -> {

        });
        btnSignature.setOnClickListener(v -> {
            startActivity(new Intent(ProfileActivity.this, EditPersonalSignActivity.class));
        });
        btnTelephone.setOnClickListener(v -> {
            startActivity(new Intent(ProfileActivity.this, EditTelephoneActivity.class));
        });
        btnLogout.setOnClickListener(v -> {
            startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
        });
    }

    private void initWidgets() {
        btnAvatar = findViewById(R.id.btn_profile_avatar);
        tvNickName = findViewById(R.id.tv_profile_nick_name);
        tvDays = findViewById(R.id.tv_profile_days);
        btnName = findViewById(R.id.btn_profile_name);
        btnTeacherNum = findViewById(R.id.btn_profile_teacher_num);
        btnDepartment = findViewById(R.id.btn_profile_department);
        btnSignature = findViewById(R.id.btn_profile_signature);
        btnTelephone = findViewById(R.id.btn_profile_telephone);
        btnLogout = findViewById(R.id.btn_profile_logout);
    }
}