package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class register extends AppCompatActivity {
    /* access modifiers changed from: private */
    public String department;
    private String[] department_list = {"", "信息科学与技术学院", "软件学院", "物理学院", "文学院", "历史学院", "化学与材料科学学院", "生命科学学院", "哲学与社会学学院"};
    private UserDBHelper mHelper;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_register);
        initSpinner();
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

    private void initSpinner() {
        ArrayAdapter<String> department_Array = new ArrayAdapter<>(this, 17367043, this.department_list);
        Spinner sp_select_department = (Spinner) findViewById(R.id.select_department);
        sp_select_department.setPrompt("请选择你所在的院系");
        sp_select_department.setAdapter(department_Array);
        sp_select_department.setSelection(0);
        sp_select_department.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                String unused = register.this.department = arg0.getItemAtPosition(arg2).toString();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void go_to_createUser(View view) {
        final EditText ed_user_name = (EditText) findViewById(R.id.input_teacher_num);
        final EditText ed_name = (EditText) findViewById(R.id.name);
        String user_name = ed_user_name.getText().toString();
        String name = ed_name.getText().toString();
        List<teacher> result = this.mHelper.query_teacher(String.format("user_name='%s'", new Object[]{user_name}));
        if (user_name.equals("") || name.equals("") || this.department.equals("")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle((CharSequence) "验证身份信息");
            builder.setMessage((CharSequence) "您没有将验证信息填写完整，请将信息填写完整后点击下一步");
            builder.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder.create().show();
        } else if (result.isEmpty()) {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
            builder2.setTitle((CharSequence) "验证身份信息");
            builder2.setMessage((CharSequence) "数据库中并没有录入您的信息，请仔细核对您的教职工号是否正确");
            builder2.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    ed_user_name.setText("");
                }
            });
            builder2.create().show();
        } else {
            if (!this.mHelper.query_user(String.format("user_name='%s'", new Object[]{user_name})).isEmpty()) {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setTitle((CharSequence) "验证身份信息");
                builder3.setMessage((CharSequence) "您已有创建好的账号，如忘记密码请点击下方按钮找回");
                builder3.setPositiveButton((CharSequence) "忘记密码", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        register.this.startActivity(new Intent(register.this, forgetPwd.class));
                    }
                });
                builder3.create().show();
            } else if (!result.get(0).getTeacher_name().equals(name) || !result.get(0).getDepartment().equals(this.department)) {
                AlertDialog.Builder builder4 = new AlertDialog.Builder(this);
                builder4.setTitle((CharSequence) "验证身份信息");
                builder4.setMessage((CharSequence) "您可以在本系统注册账号，但您的个人信息不正确，请仔细核对。");
                builder4.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ed_name.setText("");
                    }
                });
                builder4.create().show();
            } else {
                Intent intent = new Intent(this, create_User.class);
                intent.putExtra("user_name", user_name);
                startActivity(intent);
            }
        }
    }
}
