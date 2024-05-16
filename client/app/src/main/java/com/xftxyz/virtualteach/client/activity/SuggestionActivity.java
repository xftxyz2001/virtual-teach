package com.xftxyz.virtualteach.client.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.xftxyz.virtualteach.client.R;

public class SuggestionActivity extends AppCompatActivity {

    private RadioGroup rgQuesType;
    private EditText etQuesDescribe;
    private EditText etContactInformation;
    private Button btnSuggestionCommit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_suggestion);

        initWidgets();
        initListeners();
    }

    private void initListeners() {
        rgQuesType.setOnCheckedChangeListener((group, checkedId) -> {
//            if (checkedId == R.id.rb_base_func) {
//            } else if (checkedId == R.id.rb_crash_flashback) {
//            } else if (checkedId == R.id.rb_display_abnormalities) {
//            } else if (checkedId == R.id.rb_sys_inform) {
//            } else if (checkedId == R.id.rb_else_problem) {
//            }
        });
        btnSuggestionCommit.setOnClickListener(v -> {
            String quesDescribe = etQuesDescribe.getText().toString();
            String contactInformation = etContactInformation.getText().toString();


        });
    }

    private void initWidgets() {
        rgQuesType = findViewById(R.id.rg_ques_type);
        etQuesDescribe = findViewById(R.id.et_ques_describe);
        etContactInformation = findViewById(R.id.et_contact_information);
        btnSuggestionCommit = findViewById(R.id.btn_suggestion_commit);
    }
}