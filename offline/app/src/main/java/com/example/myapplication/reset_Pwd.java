package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class reset_Pwd extends AppCompatActivity {
    private List<user> data = new ArrayList();
    private UserDBHelper mHelper;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_reset_pwd);
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

    public void confirm_modify(View view) {
        String user_name;
        final EditText ed_new_pwd = (EditText) findViewById(R.id.new_pwd);
        final EditText ed_new_pwd_confirm = (EditText) findViewById(R.id.new_pwd_confirm);
        String new_pwd = ed_new_pwd.getText().toString();
        String new_pwd_confirm = ed_new_pwd_confirm.getText().toString();
        Intent intent = getIntent();
        if (intent != null) {
            user_name = intent.getStringExtra("user_name");
        } else {
            user_name = "";
        }
        if (new_pwd.equals("") || new_pwd_confirm.equals("")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle((CharSequence) "重置密码");
            builder.setMessage((CharSequence) "您有信息未填写完整，请重新填写后继续");
            builder.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder.create().show();
        } else if (!new_pwd.equals(new_pwd_confirm)) {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
            builder2.setTitle((CharSequence) "重置密码");
            builder2.setMessage((CharSequence) "两次输入的密码不相同，请重新输入后重试");
            builder2.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    ed_new_pwd.setText("");
                    ed_new_pwd_confirm.setText("");
                }
            });
            builder2.create().show();
        } else {
            new user();
            user u = this.mHelper.query_user(String.format("user_name='%s'", new Object[]{user_name})).get(0);
            if (u != null) {
                u.setPassword(new_pwd);
                this.mHelper.update_user(u, String.format("user_name='%s'", new Object[]{user_name}));
                startActivity(new Intent(this, logIn.class));
            }
        }
    }

    public void cancel(View view) {
        startActivity(new Intent(this, logIn.class));
    }
}
