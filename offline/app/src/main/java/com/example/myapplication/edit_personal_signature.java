package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class edit_personal_signature extends AppCompatActivity {
    private UserDBHelper mHelper;
    String user_name;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_edit_personal_signature);
        Intent intent = getIntent();
        if (intent != null) {
            this.user_name = intent.getStringExtra("user_name");
        } else {
            this.user_name = "";
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        UserDBHelper instance = UserDBHelper.getInstance(this, 1);
        this.mHelper = instance;
        instance.openRead();
        this.mHelper.openWrite();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mHelper.close();
    }

    public void finish_modify(View view) {
        EditText ed_personal_sign = (EditText) findViewById(R.id.ed_personal_sign);
        String new_sign = ed_personal_sign.getText().toString();
        user u = this.mHelper.query_user(String.format("user_name='%s'", new Object[]{this.user_name})).get(0);
        if (u != null) {
            u.setPersonnel_signature(new_sign);
        }
        if (ed_personal_sign.getText().toString().equals("")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle((CharSequence) "修改个性签名");
            builder.setMessage((CharSequence) "您的输入为空，请输入新的个性签名后再次尝试");
            builder.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder.create().show();
            return;
        }
        this.mHelper.update_user(u, String.format("user_name='%s'", new Object[]{this.user_name}));
        Intent intent = new Intent(this, editPersonalInfo.class);
        intent.putExtra("user_name", this.user_name);
        startActivity(intent);
    }
}
