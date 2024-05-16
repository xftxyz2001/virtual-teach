package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class editPersonalInfo extends AppCompatActivity {
    private UserDBHelper mHelper;
    String user_name;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_edit_personal_info);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        user u;
        super.onResume();
        UserDBHelper instance = UserDBHelper.getInstance(this, 1);
        this.mHelper = instance;
        instance.openRead();
        this.mHelper.openWrite();
        String stringExtra = getIntent().getStringExtra("user_name");
        this.user_name = stringExtra;
        if (this.mHelper.query_user(String.format("user_name='%s'", new Object[]{stringExtra})) != null) {
            u = this.mHelper.query_user(String.format("user_name='%s'", new Object[]{this.user_name})).get(0);
        } else {
            u = new user();
        }
        String user_nick_name = "";
        String teacher_name = "";
        String signature = "";
        String telephone_num = "";
        if (u != null) {
            user_nick_name = u.getUser_nick_name();
            teacher_name = u.getTeacher_name();
            signature = u.getPersonnel_signature();
            telephone_num = u.getTelephone_num();
        }
        ((TextView) findViewById(R.id.nick_name)).setText(user_nick_name);
        ((TextView) findViewById(R.id.teacher_name_1)).setText(teacher_name);
        ((TextView) findViewById(R.id.edit_user_teacher_num)).setText(this.user_name);
        user user = u;
        ((TextView) findViewById(R.id.department)).setText(this.mHelper.query_teacher(String.format("user_name='%s'", new Object[]{this.user_name})).get(0).getDepartment());
        ((TextView) findViewById(R.id.sign)).setText(signature);
        ((TextView) findViewById(R.id.telephone_number)).setText(telephone_num);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mHelper.close();
    }

    public void exit_logIn(View view) {
        startActivity(new Intent(this, logIn.class));
    }

    public void edit_personal_sign(View view) {
        Intent intent = new Intent(this, edit_personal_signature.class);
        intent.putExtra("user_name", this.user_name);
        startActivity(intent);
    }

    public void edit_telephone_num(View view) {
        Intent intent = new Intent(this, edit_telephone_num.class);
        intent.putExtra("user_name", this.user_name);
        startActivity(intent);
    }

    public void edit_name(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) "您无权限修改姓名");
        builder.setMessage((CharSequence) "请联系管理员进行修改\n管理员联系方式为：17795862800");
        builder.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.create().show();
    }

    public void edit_student_num(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) "您无权限修改教职工号");
        builder.setMessage((CharSequence) "请联系管理员进行修改\n管理员联系方式为：17795862800");
        builder.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.create().show();
    }

    public void edit_department(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) "您无权限修改所属学院");
        builder.setMessage((CharSequence) "请联系管理员进行修改\n管理员联系方式为：17795862800");
        builder.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.create().show();
    }

    public void back_to_mine(View view) {
        Intent intent = new Intent();
        intent.setClass(this, Main_Page.class);
        Bundle bundle = new Bundle();
        bundle.putString("user_name", this.user_name);
        bundle.putInt("bid", 2);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void Daily_Attendance(View view) {
    }
}
