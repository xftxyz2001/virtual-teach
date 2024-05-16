package com.xftxyz.virtualteach.client.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.xftxyz.virtualteach.client.R;

public class JoinSectionActivity extends AppCompatActivity {

    private EditText etJoinSectionNum;
    private Button btnApplyToJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_join_section);

        initWidgets();
        initListeners();
    }

    private void initListeners() {
        btnApplyToJoin.setOnClickListener(v -> {
            String sectionNum = etJoinSectionNum.getText().toString();
        });
    }

    private void initWidgets() {
        etJoinSectionNum = findViewById(R.id.et_join_section_num);
        btnApplyToJoin = findViewById(R.id.btn_apply_to_join);
    }
}