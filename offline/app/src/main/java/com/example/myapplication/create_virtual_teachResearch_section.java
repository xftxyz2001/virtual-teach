package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class create_virtual_teachResearch_section extends AppCompatActivity {
    String course_id;
    /* access modifiers changed from: private */
    public String[] course_id_list = {"", "153369", "154470", "147760", "138655"};
    private String[] course_list = {"", "C语言程序设计", "操作系统", "计算机网络", "大学物理"};
    String department;
    /* access modifiers changed from: private */
    public String[] department_list = {"", "信息科学与技术学院", "软件学院", "物理学院", "文学院", "历史学院", "化学与材料科学学院", "生命科学学院", "哲学与社会学学院"};
    boolean flag_course = false;
    boolean flag_department = false;
    /* access modifiers changed from: private */
    public UserDBHelper mHelper;
    List<teacher_course> result = new ArrayList();
    String user_name;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_create_virtual_teach_research_section);
        UserDBHelper instance = UserDBHelper.getInstance(this, 1);
        this.mHelper = instance;
        instance.openRead();
        this.mHelper.openWrite();
        String stringExtra = getIntent().getStringExtra("user_name");
        this.user_name = stringExtra;
        this.result = this.mHelper.query_teacher_course(String.format("user_name = %s", new Object[]{stringExtra}));
        selectCourse();
        initSpinner();
    }

    private void selectCourse() {
        ArrayAdapter<String> course_Array = new ArrayAdapter<>(this, 17367043, this.course_list);
        Spinner sp_select_course = (Spinner) findViewById(R.id.select_teachResearch_course);
        sp_select_course.setPrompt("请选择教研课程");
        sp_select_course.setAdapter(course_Array);
        sp_select_course.setSelection(0);
        sp_select_course.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {
                if (create_virtual_teachResearch_section.this.flag_course) {
                    create_virtual_teachResearch_section.this.flag_course = false;
                }
                if (arg2 > 0) {
                    for (int i = 0; i < create_virtual_teachResearch_section.this.result.size(); i++) {
                        if (create_virtual_teachResearch_section.this.result.get(i).getCourse_id().equals(create_virtual_teachResearch_section.this.course_id_list[arg2])) {
                            create_virtual_teachResearch_section.this.flag_course = true;
                            return;
                        }
                    }
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void initSpinner() {
        ArrayAdapter<String> department_Array = new ArrayAdapter<>(this, 17367043, this.department_list);
        Spinner sp_select_department = (Spinner) findViewById(R.id.select_department);
        sp_select_department.setPrompt("请选择你所在的院系");
        sp_select_department.setAdapter(department_Array);
        sp_select_department.setSelection(0);
        sp_select_department.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {
                if (create_virtual_teachResearch_section.this.flag_department) {
                    create_virtual_teachResearch_section.this.flag_department = false;
                }
                if (arg2 > 0) {
                    create_virtual_teachResearch_section create_virtual_teachresearch_section = create_virtual_teachResearch_section.this;
                    create_virtual_teachresearch_section.department = create_virtual_teachresearch_section.mHelper.query_teacher(String.format("user_name = %s", new Object[]{create_virtual_teachResearch_section.this.user_name})).get(0).getDepartment();
                    if (create_virtual_teachResearch_section.this.department.equals(create_virtual_teachResearch_section.this.department_list[arg2])) {
                        create_virtual_teachResearch_section.this.flag_department = true;
                    }
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void go_to_virtual_teachSection(View view) {
        EditText ed_create_teacher_name = (EditText) findViewById(R.id.create_teacher_name);
        EditText ed_create_section_name = (EditText) findViewById(R.id.create_section_name);
        if (ed_create_teacher_name.getText().toString().equals("")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle((CharSequence) "创建教研室");
            builder.setMessage((CharSequence) "您没有填写您的姓名，请填写后再进行提交");
            builder.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder.create().show();
            return;
        }
        if (!ed_create_teacher_name.getText().toString().equals(this.mHelper.query_user(String.format("user_name = %s", new Object[]{this.user_name})).get(0).getTeacher_name())) {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
            builder2.setTitle((CharSequence) "创建教研室");
            builder2.setMessage((CharSequence) "您提交的名字与数据库中不符，请检查后再次输入");
            builder2.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder2.create().show();
        } else if (ed_create_section_name.getText().toString().equals("")) {
            AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
            builder3.setTitle((CharSequence) "创建教研室");
            builder3.setMessage((CharSequence) "您没有填写教研室名字，请填写后再进行提交");
            builder3.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder3.create().show();
        } else if (!this.flag_course) {
            AlertDialog.Builder builder4 = new AlertDialog.Builder(this);
            builder4.setTitle((CharSequence) "创建教研室");
            builder4.setMessage((CharSequence) "您没有选择课程或是选择的课程不是您所教授的课程，请重新选择");
            builder4.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder4.create().show();
        } else if (!this.flag_department) {
            AlertDialog.Builder builder5 = new AlertDialog.Builder(this);
            builder5.setTitle((CharSequence) "创建教研室");
            builder5.setMessage((CharSequence) "您没有选择院系或是选择的课程不是您所属的院系，请重新选择");
            builder5.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder5.create().show();
        } else {
            this.flag_course = false;
            this.flag_department = false;
            AlertDialog.Builder builder6 = new AlertDialog.Builder(this);
            builder6.setTitle((CharSequence) "您已成功创建一个虚拟教研室");
            builder6.setMessage((CharSequence) "您的教研室编号为165482");
            builder6.setPositiveButton((CharSequence) "好的", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(create_virtual_teachResearch_section.this, virtual_teachResearch_section.class);
                    intent.putExtra("user_name", create_virtual_teachResearch_section.this.user_name);
                    create_virtual_teachResearch_section.this.startActivity(intent);
                }
            });
            builder6.create().show();
        }
    }
}
