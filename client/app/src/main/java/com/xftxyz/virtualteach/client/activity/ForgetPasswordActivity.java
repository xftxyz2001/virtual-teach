package com.xftxyz.virtualteach.client.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.xftxyz.virtualteach.client.R;

public class ForgetPasswordActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etTelephone;
    private EditText etVerificationCode;

    private Button btnGetVerificationCode;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forget_password);

        initWidgets();
        initListeners();
    }

    private void initListeners() {
        btnGetVerificationCode.setOnClickListener(v -> {
            // 发送验证码
        });

        btnNext.setOnClickListener(v -> {
            // 下一步
        });
    }

    private void initWidgets() {
        etUsername = findViewById(R.id.et_forget_username);
        etTelephone = findViewById(R.id.et_login_password);
        etVerificationCode = findViewById(R.id.et_forget_verify_code);

        btnGetVerificationCode = findViewById(R.id.btn_forget_send_verify_code);
        btnNext = findViewById(R.id.btn_forget_next);
    }
}