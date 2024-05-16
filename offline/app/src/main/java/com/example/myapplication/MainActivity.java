package com.example.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<db_course> data_course = new ArrayList();
    private List<db_meeting> data_meeting = new ArrayList();
    private List<news> data_news = new ArrayList();
    private List<notification> data_notification = new ArrayList();
    private List<section> data_section = new ArrayList();
    private List<section_user> data_section_user = new ArrayList();
    private List<teacher> data_teacher = new ArrayList();
    private List<teacher_course> data_teacher_course = new ArrayList();
    private List<user> data_user = new ArrayList();
    private Runnable mGoNext = new Runnable() {
        public void run() {
            MainActivity.this.startActivity(new Intent(MainActivity.this, logIn.class));
        }
    };
    private UserDBHelper mHelper;
    private String tag = "123";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        SQLiteDatabase db = openOrCreateDatabase(getFilesDir() + "/virtual_teach_research_section.db", 0, (SQLiteDatabase.CursorFactory) null);
        UserDBHelper instance = UserDBHelper.getInstance(this, 1);
        this.mHelper = instance;
        instance.onCreate(db);
        this.mHelper.openWrite();
        create_meeting();
        create_table_user();
        create_table_teacher();
        create_teach_and_research_section();
        create_section_user();
        create_course();
        create_teacher_course();
        create_news();
        create_system_notification();
        goNextPage();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mHelper.close();
    }

    private void goNextPage() {
        TextView textView = (TextView) findViewById(R.id.tv_welcome);
        new Handler().postDelayed(this.mGoNext, 0);
    }

    private void create_table_user() {
        user u = new user();
        u.setUser_name("2020118066");
        u.setTeacher_name("吕桑");
        u.setUser_nick_name("紫云墨雨");
        u.setTelephone_num("17753108484");
        u.setPassword("123456");
        u.setPersonnel_signature("C语言从入门到精通");
        user u1 = new user();
        u1.setUser_name("2020118030");
        u1.setTeacher_name("胡文松");
        u1.setUser_nick_name("胡老师");
        u1.setTelephone_num("17795862608");
        u1.setPassword("Qh08258Jl");
        u1.setPersonnel_signature("公诚勤朴");
        this.data_user.add(u);
        this.data_user.add(u1);
        Log.d(this.tag, String.valueOf(this.mHelper.insert_user(this.data_user)));
    }

    private void create_table_teacher() {
        teacher t1 = new teacher();
        t1.setUser_name("2020118055");
        t1.setTeacher_name("刘一手");
        t1.setDepartment("信息科学与技术学院");
        teacher t2 = new teacher();
        t2.setUser_name("2020118030");
        t2.setTeacher_name("胡文松");
        t2.setDepartment("软件学院");
        teacher t3 = new teacher();
        t3.setUser_name("2020118066");
        t3.setTeacher_name("吕桑");
        t3.setDepartment("软件学院");
        teacher t4 = new teacher();
        t4.setUser_name("2020118078");
        t4.setTeacher_name("李欣雨");
        t4.setDepartment("物理学院");
        teacher t5 = new teacher();
        t5.setUser_name("2020118107");
        t5.setTeacher_name("陈龙");
        t5.setDepartment("生命科学学院");
        this.data_teacher.add(t1);
        this.data_teacher.add(t2);
        this.data_teacher.add(t3);
        this.data_teacher.add(t4);
        this.data_teacher.add(t5);
        Log.d(this.tag, String.valueOf(this.mHelper.insert_teacher(this.data_teacher)));
    }

    private void create_teach_and_research_section() {
        section s1 = new section();
        s1.setId("494611");
        s1.setName("C语言程序设计虚拟教研室");
        s1.setCourse_id("153369");
        s1.setGroup_leader("2020118030");
        s1.setDepartment("软件学院");
        section s2 = new section();
        s2.setId("494612");
        s2.setName("操作系统虚拟教研室");
        s2.setCourse_id("154470");
        s2.setGroup_leader("2020118030");
        s2.setDepartment("软件学院");
        section s3 = new section();
        s3.setId("494613");
        s3.setName("计算机网络虚拟教研室");
        s3.setCourse_id("147760");
        s3.setGroup_leader("2020118066");
        s3.setDepartment("软件学院");
        section s4 = new section();
        s4.setId("494614");
        s4.setName("大学物理虚拟教研室");
        s4.setCourse_id("138655");
        s4.setGroup_leader("2020118078");
        s4.setDepartment("物理学院");
        this.data_section.add(s1);
        this.data_section.add(s2);
        this.data_section.add(s3);
        this.data_section.add(s4);
        Log.d(this.tag, String.valueOf(this.mHelper.insert_teach_and_research_section(this.data_section)));
    }

    private void create_meeting() {
        db_meeting m1 = new db_meeting();
        m1.setId("123455");
        m1.setMeeting_topic("C语言程序设计例会");
        m1.setStart_time("2024-03-12");
        m1.setUser_name("2020118030");
        m1.setInvite_num("109-160-255");
        db_meeting m2 = new db_meeting();
        m2.setId("564815");
        m2.setMeeting_topic("操作系统公开课");
        m2.setStart_time("2024-03-25");
        m2.setUser_name("2020118066");
        m2.setInvite_num("154-854-244");
        db_meeting m3 = new db_meeting();
        m3.setId("354655");
        m3.setMeeting_topic("大学物理光学研讨会");
        m3.setStart_time("2024-03-31");
        m3.setUser_name("2020118078");
        m3.setInvite_num("324-832-132");
        db_meeting m4 = new db_meeting();
        m4.setId("354656");
        m4.setMeeting_topic("计算机网络会议");
        m4.setStart_time("2024-04-25");
        m4.setUser_name("2020118078");
        m4.setInvite_num("324-832-132");
        this.data_meeting.add(m1);
        this.data_meeting.add(m2);
        this.data_meeting.add(m3);
        this.data_meeting.add(m4);
        Log.d(this.tag, String.valueOf(this.mHelper.insert_meeting(this.data_meeting)));
    }

    private void create_section_user() {
        section_user su1 = new section_user();
        su1.setId("494611");
        su1.setUser_name("2020118030");
        section_user su2 = new section_user();
        su2.setId("494611");
        su2.setUser_name("2020118066");
        section_user su3 = new section_user();
        su3.setId("494611");
        su3.setUser_name("2020118055");
        section_user su4 = new section_user();
        su4.setId("494612");
        section_user su5 = new section_user();
        su5.setId("494613");
        su5.setUser_name("2020118066");
        section_user su6 = new section_user();
        su6.setId("494614");
        su6.setUser_name("2020118078");
        section_user su7 = new section_user();
        su7.setId("494612");
        su7.setUser_name("2020118030");
        this.data_section_user.add(su1);
        this.data_section_user.add(su2);
        this.data_section_user.add(su3);
        this.data_section_user.add(su4);
        this.data_section_user.add(su5);
        this.data_section_user.add(su6);
        this.data_section_user.add(su7);
        Log.d(this.tag, String.valueOf(this.mHelper.insert_section_user(this.data_section_user)));
    }

    private void create_course() {
        db_course d1 = new db_course();
        d1.setCourse_id("153369");
        d1.setCourse_name("C语言程序设计");
        d1.setCourse_introduction("这是C语言程序设计课程，是一门计算机科学和编程的基础课程，旨在教授学生编写、调试和理解使用 C 语言编写的程序。");
        d1.setDepartment("软件学院");
        db_course d2 = new db_course();
        d2.setCourse_id("154470");
        d2.setCourse_name("操作系统");
        d2.setCourse_introduction("这是操作系统课程，是一门计算机科学和编程的基础课程");
        d2.setDepartment("软件学院");
        db_course d3 = new db_course();
        d3.setCourse_id("147760");
        d3.setCourse_name("计算机网络");
        d3.setCourse_introduction("这是计算机网络课程，是一门计算机科学和编程的基础课程");
        d3.setDepartment("软件学院");
        db_course d4 = new db_course();
        d4.setCourse_id("138655");
        d4.setCourse_name("大学物理");
        d4.setCourse_introduction("这是大学物理课程，是一门介绍基本物理学常识的必修课程");
        d4.setDepartment("物理学院");
        this.data_course.add(d1);
        this.data_course.add(d2);
        this.data_course.add(d3);
        this.data_course.add(d4);
        Log.d(this.tag, String.valueOf(this.mHelper.insert_course(this.data_course)));
    }

    private void create_teacher_course() {
        teacher_course tc1 = new teacher_course();
        tc1.setCourse_id("153369");
        tc1.setUser_name("2020118030");
        teacher_course tc2 = new teacher_course();
        tc2.setCourse_id("153369");
        tc2.setUser_name("2020118066");
        teacher_course tc3 = new teacher_course();
        tc3.setCourse_id("153369");
        tc3.setUser_name("2020118055");
        teacher_course tc4 = new teacher_course();
        tc4.setCourse_id("154470");
        tc4.setUser_name("2020118030");
        teacher_course tc5 = new teacher_course();
        tc5.setCourse_id("154470");
        tc5.setUser_name("2020118066");
        teacher_course tc6 = new teacher_course();
        tc6.setCourse_id("147760");
        tc6.setUser_name("2020118066");
        teacher_course tc7 = new teacher_course();
        tc7.setCourse_id("147760");
        tc7.setUser_name("2020118030");
        teacher_course tc8 = new teacher_course();
        tc8.setCourse_id("138655");
        tc8.setUser_name("2020118078");
        this.data_teacher_course.add(tc1);
        this.data_teacher_course.add(tc2);
        this.data_teacher_course.add(tc3);
        this.data_teacher_course.add(tc4);
        this.data_teacher_course.add(tc5);
        this.data_teacher_course.add(tc6);
        this.data_teacher_course.add(tc7);
        this.data_teacher_course.add(tc8);
        Log.d(this.tag, String.valueOf(this.mHelper.insert_teacher_course(this.data_teacher_course)));
    }

    private void create_news() {
        news n1 = new news();
        n1.setId("000001");
        n1.setTopic("C语言程序设计2024-03-15会议记录公告");
        n1.setContent("会议讨论了当前C语言教学的现状和挑战，提出了一些改进教学方法和课程内容的建议。\n各位老师分享了在教学实践中的成功经验和案例，并进行了深入的交流和讨论。\n会议决定成立教学改革小组，负责制定具体的行动计划和实施方案。出席人员：\n王老师（主持人）\n张老师\n李老师\n孙老师\n等");
        n1.setDate("2024-03-15");
        n1.setPublisher("C语言程序设计虚拟教研室");
        news n2 = new news();
        n2.setId("000002");
        n2.setTopic("评选操作系统优秀教学资源公告");
        n2.setContent("一等奖：\n教学课件：\n《操作系统原理与实践》PPT，提交者：张教授\n二等奖：\n实验案例：\n《操作系统虚拟内存实验设计案例》，提交者：李老师\n教学视频：\n操作系统进程管理实验视频，提交者：王老师\n三等奖：\n在线资源：\n操作系统课程在线学习平台，提交者：陈教授\n");
        n2.setDate("2024-03-17");
        n2.setPublisher("操作系统虚拟教研室");
        news n3 = new news();
        n3.setId("000003");
        n3.setTopic("大学物理课程示范课评选结果公示");
        n3.setContent("一等奖：\n示范课名称：光学原理与应用示范课\n授课教师：张教授\n评语：张教授深入浅出地讲解了光学原理，生动形象地展示了光学现象，使学生在实验中感受到了科学的魅力，教学效果显著。\n二等奖：\n示范课名称：力学基础与实践示范课\n授课教师：王老师\n评语：王老师通过丰富的实例和生动的动画展示，让学生深入理解了力学基础知识，课堂氛围活跃，教学内容紧密联系实际，教学效果良好。\n三等奖：\n示范课名称：热学原理与实践示范课\n授课教师：李老师\n评语：李老师课堂组织严谨，案例详实，让学生在课堂中充分领悟了热学原理，但在引导学生思考和互动方面还有提升空间。\n感谢所有参与示范课评选的教师，你们的精彩课程为学生的学习提供了极大的帮助和启发！");
        n3.setDate("2024-04-10");
        n3.setPublisher("大学物理虚拟教研室");
        news n4 = new news();
        n4.setId("000004");
        n4.setTopic("计算机网络2024-04-16会议记录公告");
        n4.setContent("会议围绕网络安全、5G、区块链、物联网、云计算等议题展开深入讨论，各位专家分享了丰富的经验和见解。\n强调了网络安全和隐私保护的重要性，以及未来网络技术的发展趋势。\n提出了加强跨学科合作、推动技术创新和加强人才培养的建议。\n");
        n4.setDate("2024-04-16");
        n4.setPublisher("计算机网络虚拟教研室");
        news n5 = new news();
        n5.setId("000005");
        n5.setTopic("C语言程序设计最新教研成果");
        n5.setContent("最新研究基于当前C语言程序设计教学的需求和趋势，开发了一套新一代的教学资源平台。该平台整合了在线学习、实验演示、项目实践等功能，通过互动性和个性化定制，提升了学生的学习兴趣和动手能力。");
        n5.setDate("2024-04-25");
        n5.setPublisher("C语言程序设计虚拟教研室");
        this.data_news.add(n1);
        this.data_news.add(n2);
        this.data_news.add(n3);
        this.data_news.add(n4);
        this.data_news.add(n5);
        Log.d(this.tag, String.valueOf(this.mHelper.insert_news(this.data_news)));
    }

    private void create_system_notification() {
        notification n1 = new notification();
        n1.setId("121308");
        n1.setTopic("系统更新公告");
        n1.setNotification_type("更新公告");
        n1.setContent("系统更新至1.0.2版本，本版本修正了之前存在的一些问题，引入了一些新的bug");
        n1.setDate("2024-04-06");
        notification n2 = new notification();
        n2.setId("121409");
        n2.setTopic("系统维护公告");
        n2.setNotification_type("维护公告");
        n2.setContent("本系统将于2024-04-09日00:00进行系统维护，为您带来不便敬请谅解");
        n2.setDate("2024-04-08");
        notification n3 = new notification();
        n3.setId("131509");
        n3.setTopic("系统问题反馈开启");
        n3.setNotification_type("更新公告");
        n3.setContent("本系统将于2024-05-10日正式开启用户反馈通道，届时用户可以通过问题反馈向我们提出意见，感谢您的反馈");
        n3.setDate("2024-05-05");
        this.data_notification.add(n1);
        this.data_notification.add(n2);
        this.data_notification.add(n3);
        Log.d(this.tag, String.valueOf(this.mHelper.insert_system_notification(this.data_notification)));
    }
}
