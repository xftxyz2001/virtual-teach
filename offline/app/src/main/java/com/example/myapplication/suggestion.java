package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class suggestion extends AppCompatActivity {
    /* access modifiers changed from: private */
    public String user_name;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_suggestion);
        Intent intent = getIntent();
        if (intent != null) {
            this.user_name = intent.getStringExtra("user_name");
        } else {
            this.user_name = "";
        }
    }

    public void commit_suggestion(View view) {
        EditText ques_describe = (EditText) findViewById(R.id.ques_describe);
        EditText contact_information = (EditText) findViewById(R.id.contact_information);
        RadioGroup rg_ques_type = (RadioGroup) findViewById(R.id.rg_ques_type);
        rg_ques_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
            }
        });
        RadioButton radioButton = (RadioButton) findViewById(rg_ques_type.getCheckedRadioButtonId());
        if (rg_ques_type.getCheckedRadioButtonId() == -1) {
            AlertDialog.Builder builder_1 = new AlertDialog.Builder(this);
            builder_1.setTitle((CharSequence) "问题反馈");
            builder_1.setMessage((CharSequence) "请您选择反馈问题的类型，否则将无法提交反馈");
            builder_1.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder_1.create().show();
        } else if (ques_describe.getText().toString().equals("")) {
            AlertDialog.Builder builder_2 = new AlertDialog.Builder(this);
            builder_2.setTitle((CharSequence) "问题反馈");
            builder_2.setMessage((CharSequence) "您的反馈缺少必要的问题描述，请详细描述您遇到的问题");
            builder_2.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder_2.create().show();
        } else if (contact_information.getText().toString().equals("")) {
            AlertDialog.Builder builder_3 = new AlertDialog.Builder(this);
            builder_3.setTitle((CharSequence) "问题反馈");
            builder_3.setMessage((CharSequence) "您的反馈缺少必要的联系方式，请留下您的联系方式方便我们对您进行反馈");
            builder_3.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder_3.create().show();
        } else if (contact_information.getText().length() != 11) {
            AlertDialog.Builder builder_4 = new AlertDialog.Builder(this);
            builder_4.setTitle((CharSequence) "问题反馈");
            builder_4.setMessage((CharSequence) "您的联系方式是错误的，请您留下正确的联系方式");
            builder_4.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder_4.create().show();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle((CharSequence) "问题反馈");
            builder.setMessage((CharSequence) "您的反馈我们已经收到，我们将及时处理");
            builder.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(suggestion.this, about.class);
                    intent.putExtra("user_name", suggestion.this.user_name);
                    suggestion.this.startActivity(intent);
                }
            });
            builder.create().show();
        }
    }
}
