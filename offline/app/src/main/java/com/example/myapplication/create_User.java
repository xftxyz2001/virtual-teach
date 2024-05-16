package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class create_User extends AppCompatActivity {
    private List<user> data = new ArrayList();
    private String department;
    private UserDBHelper mHelper;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_create_user);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(getFilesDir() + "/virtual_teach_research_section.db", 0, (SQLiteDatabase.CursorFactory) null);
        UserDBHelper instance = UserDBHelper.getInstance(this, 1);
        this.mHelper = instance;
        instance.openWrite();
        this.mHelper.openRead();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mHelper.close();
    }

    public void go_to_logIn(View view) {
        String user_name;
        Intent intent = getIntent();
        if (intent != null) {
            user_name = intent.getStringExtra("user_name");
        } else {
            user_name = "";
        }
        EditText user_nick_name = (EditText) findViewById(R.id.create_user_nick_name);
        final EditText password = (EditText) findViewById(R.id.create_pwd);
        final EditText password_verify = (EditText) findViewById(R.id.create_pwd_verify);
        final EditText telephone_num = (EditText) findViewById(R.id.input_telephoneNum);
        String real_name = this.mHelper.query_teacher(String.format("user_name='%s'", new Object[]{user_name})).get(0).getTeacher_name();
        if (user_nick_name.equals("") || password.equals("") || password_verify.equals("") || telephone_num.equals("")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle((CharSequence) "创建用户");
            builder.setMessage((CharSequence) "您的信息未填写完整，请填写完整后再次尝试");
            builder.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder.create().show();
        } else if (!password.getText().toString().equals(password_verify.getText().toString())) {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
            builder2.setTitle((CharSequence) "创建用户");
            builder2.setMessage((CharSequence) "您两次输入的密码不一致，请重新输入");
            builder2.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    password.setText("");
                    password_verify.setText("");
                }
            });
            builder2.create().show();
        } else if (telephone_num.length() != 11) {
            AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
            builder3.setTitle((CharSequence) "创建用户");
            builder3.setMessage((CharSequence) "您的电话号码是错误的，请重新输入，再次尝试");
            builder3.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    telephone_num.setText("");
                }
            });
            builder3.create().show();
        } else {
            user u = new user();
            u.setUser_name(user_name);
            u.setTelephone_num(telephone_num.getText().toString());
            u.setUser_nick_name(user_nick_name.getText().toString());
            u.setPassword(password.getText().toString());
            u.setTeacher_name(real_name);
            u.setPersonnel_signature("");
            this.data.add(u);
            if (this.mHelper.insert_user(this.data) != -1) {
                startActivity(new Intent(this, logIn.class));
                return;
            }
            AlertDialog.Builder builder4 = new AlertDialog.Builder(this);
            builder4.setTitle((CharSequence) "创建用户");
            builder4.setMessage((CharSequence) "创建用户失败，请重试");
            builder4.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder4.create().show();
        }
    }
}
