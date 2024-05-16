package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class edit_telephone_num extends AppCompatActivity {
    private UserDBHelper mHelper;
    int randomNum = -1;
    String user_name;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_edit_telephone_num);
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

    public void complete_modify(final View view) {
        final EditText ed_new_telephone_num = (EditText) findViewById(R.id.new_telephone_num);
        final EditText ed_verify_num = (EditText) findViewById(R.id.verify);
        String new_telephone_num = ed_new_telephone_num.getText().toString();
        String verify_num = ed_verify_num.getText().toString();
        if (new_telephone_num.equals("")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle((CharSequence) "编辑电话号码");
            builder.setMessage((CharSequence) "检测到您未输入新电话号码,请输入新电话号码再次尝试");
            builder.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder.create().show();
        } else if (new_telephone_num.length() != 11) {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
            builder2.setTitle((CharSequence) "编辑电话号码");
            builder2.setMessage((CharSequence) "您输入的电话号码不合法，请重新输入");
            builder2.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    ed_new_telephone_num.setText("");
                }
            });
            builder2.create().show();
        } else if (verify_num.equals("")) {
            AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
            builder3.setTitle((CharSequence) "编辑电话号码");
            builder3.setMessage((CharSequence) "请输入验证码，如未发送，请点击下方按钮");
            builder3.setPositiveButton((CharSequence) "发送验证码", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    edit_telephone_num.this.send_verify_num_2(view);
                }
            });
            builder3.create().show();
        } else {
            int i = this.randomNum;
            if (i == -1) {
                AlertDialog.Builder builder4 = new AlertDialog.Builder(this);
                builder4.setTitle((CharSequence) "编辑电话号码");
                builder4.setMessage((CharSequence) "还未向您发送验证码，请点击下方按钮");
                builder4.setPositiveButton((CharSequence) "发送验证码", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        edit_telephone_num.this.send_verify_num_2(view);
                    }
                });
                builder4.create().show();
            } else if (!verify_num.equals(String.valueOf(i))) {
                AlertDialog.Builder builder5 = new AlertDialog.Builder(this);
                builder5.setTitle((CharSequence) "编辑电话号码");
                builder5.setMessage((CharSequence) "您输入的验证码有误，请重新输入");
                builder5.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ed_verify_num.setText("");
                    }
                });
                builder5.create().show();
            } else {
                UserDBHelper userDBHelper = this.mHelper;
                if (userDBHelper != null) {
                    user u = userDBHelper.query_user(String.format("user_name='%s'", new Object[]{this.user_name})).get(0);
                    u.setTelephone_num(new_telephone_num);
                    this.mHelper.update_user(u, String.format("user_name='%s'", new Object[]{this.user_name}));
                }
                Intent intent = new Intent(this, editPersonalInfo.class);
                intent.putExtra("user_name", this.user_name);
                startActivity(intent);
            }
        }
    }

    public void send_verify_num_2(View view) {
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
