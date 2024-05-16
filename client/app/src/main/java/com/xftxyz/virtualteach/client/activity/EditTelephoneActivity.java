package com.xftxyz.virtualteach.client.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.xftxyz.virtualteach.client.R;

public class EditTelephoneActivity extends AppCompatActivity {

    private EditText etNewTelephoneNum;
    private EditText etVerifyCode;
    private Button btnGetVerifyCode;
    private Button btnFinishModify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_telephone);

        initWidgets();
        initListeners();
    }

    private void initListeners() {
        btnGetVerifyCode.setOnClickListener(v -> {
            // 获取验证码
        });
        btnFinishModify.setOnClickListener(v -> {
            // 完成修改
            String newTelephoneNum = etNewTelephoneNum.getText().toString();
            String verifyCode = etVerifyCode.getText().toString();
        });
    }

    private void initWidgets() {
        etNewTelephoneNum = findViewById(R.id.et_new_telephone_num);
        etVerifyCode = findViewById(R.id.et_verify_code);
        btnGetVerifyCode = findViewById(R.id.btn_get_verify_code);
        btnFinishModify = findViewById(R.id.btn_finish_modify);
    }
}