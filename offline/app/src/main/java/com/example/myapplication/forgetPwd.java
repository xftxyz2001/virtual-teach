package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class forgetPwd extends AppCompatActivity {
    private List<user> data = new ArrayList();
    private UserDBHelper mHelper;
    int randomNum;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_forget_pwd);
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

    public void goNext(final View view) {
        final EditText ed_user = (EditText) findViewById(R.id.userName);
        final EditText ed_telephone_num = (EditText) findViewById(R.id.telephone_num);
        final EditText ed_verify_code = (EditText) findViewById(R.id.verify_code);
        if (ed_user.getText().toString().equals("") || ed_telephone_num.getText().toString().equals("") || ed_verify_code.getText().toString().equals("")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle((CharSequence) "忘记密码");
            builder.setMessage((CharSequence) "检测到您的个人信息并未填写完整，请完善信息后重试");
            builder.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder.create().show();
            return;
        }
        if (this.mHelper.query_user(String.format("user_name='%s'", new Object[]{ed_user.getText().toString()})).isEmpty()) {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
            builder2.setTitle((CharSequence) "忘记密码");
            builder2.setMessage((CharSequence) "数据库中不存在您的用户信息，请检查您输入的用户名是否正确\n若您还没有账户，请点击下方按钮注册账户");
            builder2.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    ed_user.setText("");
                }
            });
            builder2.setNegativeButton((CharSequence) "立即注册", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    forgetPwd.this.startActivity(new Intent(forgetPwd.this, register.class));
                }
            });
            builder2.create().show();
        } else if (ed_telephone_num.getText().toString().length() != 11) {
            AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
            builder3.setTitle((CharSequence) "忘记密码");
            builder3.setMessage((CharSequence) "您输入的电话号格式有误，请重新输入");
            builder3.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    ed_telephone_num.setText("");
                }
            });
            builder3.create().show();
        } else {
            if (!ed_telephone_num.getText().toString().equals(this.mHelper.query_user(String.format("user_name='%s'", new Object[]{ed_user.getText().toString()})).get(0).getTelephone_num())) {
                AlertDialog.Builder builder4 = new AlertDialog.Builder(this);
                builder4.setTitle((CharSequence) "忘记密码");
                builder4.setMessage((CharSequence) "您输入的电话号码与数据库中的号码不符，请重新输入");
                builder4.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ed_telephone_num.setText("");
                    }
                });
                builder4.create().show();
            } else if (this.randomNum == 0) {
                AlertDialog.Builder builder5 = new AlertDialog.Builder(this);
                builder5.setTitle((CharSequence) "忘记密码");
                builder5.setMessage((CharSequence) "还未发送验证码，请点击获取验证码");
                builder5.setPositiveButton((CharSequence) "获取验证码", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        forgetPwd.this.send_verify_num(view);
                    }
                });
                builder5.create().show();
            } else if (!ed_verify_code.getText().toString().equals(String.valueOf(this.randomNum))) {
                AlertDialog.Builder builder6 = new AlertDialog.Builder(this);
                builder6.setTitle((CharSequence) "忘记密码");
                builder6.setMessage((CharSequence) "您输入的验证码有误，请重新输入，或等待60s后重新发送");
                builder6.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ed_verify_code.setText("");
                    }
                });
                builder6.create().show();
            } else {
                Intent intent = new Intent(this, reset_Pwd.class);
                intent.putExtra("user_name", ed_user.getText().toString());
                startActivity(intent);
            }
        }
    }

    public void send_verify_num(View view) {
        int nextInt = new Random().nextInt((999999 - 100000) + 1) + 100000;
        this.randomNum = nextInt;
        Log.d("verification_num", String.valueOf(nextInt));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) "已发送验证码");
        builder.setMessage((CharSequence) "已发送验证码至您的手机\n若60s内未收到验证码请再次尝试");
        builder.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.create().show();
    }
}
