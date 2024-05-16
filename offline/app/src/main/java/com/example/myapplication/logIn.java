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

public class logIn extends AppCompatActivity {
    private List<user> data = new ArrayList();
    private UserDBHelper mHelper;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.login_interface);
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

    public void forgetPwd_Click(View view) {
        startActivity(new Intent(this, forgetPwd.class));
    }

    public void go_to_register(View view) {
        startActivity(new Intent(this, register.class));
    }

    public void logIn_Click(View view) {
        final EditText ed_user_name = (EditText) findViewById(R.id.userName);
        final EditText ed_password = (EditText) findViewById(R.id.password);
        if (ed_password.getText().toString().equals("") || ed_user_name.getText().toString().equals("")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle((CharSequence) "登录");
            builder.setMessage((CharSequence) "您没有输入账号或者密码，请输入账号密码进行登录");
            builder.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    ed_user_name.setText("");
                    ed_password.setText("");
                }
            });
            builder.create().show();
            return;
        }
        if (this.mHelper.query_user(String.format("user_name='%s'", new Object[]{ed_user_name.getText().toString()})).isEmpty()) {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
            builder2.setTitle((CharSequence) "登录");
            builder2.setMessage((CharSequence) "您的账号不存在，请重新输入,若没有账号，请进行注册");
            builder2.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    ed_user_name.setText("");
                    ed_password.setText("");
                }
            });
            builder2.setNegativeButton((CharSequence) "立即注册", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    ed_user_name.setText("");
                    ed_password.setText("");
                    logIn.this.startActivity(new Intent(logIn.this, register.class));
                }
            });
            builder2.create().show();
            return;
        }
        if (!this.mHelper.query_user(String.format("user_name='%s'", new Object[]{ed_user_name.getText().toString()})).get(0).getPassword().equals(ed_password.getText().toString())) {
            AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
            builder3.setTitle((CharSequence) "登录");
            builder3.setMessage((CharSequence) "您的账号密码不匹配，请重新输入");
            builder3.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    ed_user_name.setText("");
                    ed_password.setText("");
                }
            });
            builder3.create().show();
            return;
        }
        Intent intent = new Intent(this, Main_Page.class);
        Bundle bundle = new Bundle();
        bundle.putString("user_name", ed_user_name.getText().toString());
        bundle.putInt("bid", 0);
        intent.putExtras(bundle);
        startActivity(intent);
        store.set("user_name", ed_user_name.getText().toString());
    }
}
