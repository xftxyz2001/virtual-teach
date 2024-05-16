package com.xftxyz.virtualteach.client.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.xftxyz.virtualteach.client.R;

public class EditPersonalSignActivity extends AppCompatActivity {

    private EditText etPersonalSign;
    private Button btnSignFinishModify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_personal_sign);

        initWidgets();
        initListeners();
    }

    private void initListeners() {
        btnSignFinishModify.setOnClickListener(v -> {
            String sign = etPersonalSign.getText().toString();

        });
    }

    private void initWidgets() {
        etPersonalSign = findViewById(R.id.et_personal_sign);
        btnSignFinishModify = findViewById(R.id.btn_sign_finish_modify);
    }
}