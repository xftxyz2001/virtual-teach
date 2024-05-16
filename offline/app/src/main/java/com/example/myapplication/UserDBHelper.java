package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class UserDBHelper extends SQLiteOpenHelper {
    private static final String db = "virtual_teach_research_section.db";
    private static UserDBHelper helper = null;
    public static final String table_course = "course";
    public static final String table_meeting = "meeting";
    public static final String table_news = "news";
    public static final String table_section_user = "section_user";
    public static final String table_system_notification = "system_notification";
    public static final String table_teach_and_research_section = "teach_and_research_section";
    public static final String table_teacher = "teacher";
    public static final String table_teacher_course = "teacher_course";
    public static final String table_user = "user";
    String create_table_course = "CREATE TABLE IF NOT EXISTS course (course_id VARCHAR PRIMARY KEY,course_name VARCHAR,course_introduction VARCHAR,department VARCHAR);";
    String create_table_meeting = "CREATE TABLE IF NOT EXISTS meeting (id VARCHAR PRIMARY KEY,invite_num VARCHAR,meeting_topic VARCHAR,user_name VARCHAR,start_time VARCHAR);";
    String create_table_news = "CREATE TABLE IF NOT EXISTS news (id VARCHAR PRIMARY KEY,topic VARCHAR,content VARCHAR,date VARCHAR,publisher VARCHAR);";
    String create_table_section_user = "CREATE TABLE IF NOT EXISTS section_user (id VARCHAR ,user_name VARCHAR,PRIMARY KEY (id, user_name));";
    String create_table_system_notification = "CREATE TABLE IF NOT EXISTS system_notification (id VARCHAR PRIMARY KEY,topic VARCHAR,notification_type VARCHAR,content VARCHAR,date VARCHAR);";
    String create_table_teach_and_research_section = "CREATE TABLE IF NOT EXISTS teach_and_research_section (id VARCHAR PRIMARY KEY,name VARCHAR,group_leader_user_name VARCHAR NOT NULL,course_id VARCHAR,department VARCHAR);";
    String create_table_teacher_course = "CREATE TABLE IF NOT EXISTS teacher_course (user_name VARCHAR ,course_id VARCHAR,PRIMARY KEY (user_name,course_id));";
    String create_teacher = "CREATE TABLE IF NOT EXISTS teacher (user_name VARCHAR PRIMARY KEY,teacher_name VARCHAR,department VARCHAR);";
    String create_user = "CREATE TABLE IF NOT EXISTS user (user_name VARCHAR PRIMARY KEY,teacher_name VARCHAR NOT NULL,user_nick_name VARCHAR NOT NULL,password VARCHAR NOT NULL,telephone_num VARCHAR NOT NULL,personnel_signature VARCHAR);";
    private SQLiteDatabase mDB = null;

    private UserDBHelper(Context context, int version) {
        super(context, db, (SQLiteDatabase.CursorFactory) null, version);
    }

    public static UserDBHelper getInstance(Context context, int version) {
        if (version > 0 && helper == null) {
            helper = new UserDBHelper(context, version);
        }
        return helper;
    }

    public SQLiteDatabase openRead() {
        SQLiteDatabase sQLiteDatabase = this.mDB;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            this.mDB = helper.getReadableDatabase();
        }
        return this.mDB;
    }

    public SQLiteDatabase openWrite() {
        SQLiteDatabase sQLiteDatabase = this.mDB;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            this.mDB = helper.getWritableDatabase();
        }
        return this.mDB;
    }

    public void onCreate(SQLiteDatabase db2) {
        db2.execSQL(this.create_user);
        db2.execSQL(this.create_teacher);
        db2.execSQL(this.create_table_teach_and_research_section);
        db2.execSQL(this.create_table_section_user);
        db2.execSQL(this.create_table_course);
        db2.execSQL(this.create_table_teacher_course);
        db2.execSQL(this.create_table_meeting);
        db2.execSQL(this.create_table_news);
        db2.execSQL(this.create_table_system_notification);
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists user");
        sqLiteDatabase.execSQL("drop table if exists teacher");
        sqLiteDatabase.execSQL("drop table if exists teach_and_research_section");
        sqLiteDatabase.execSQL("drop table if exists section_user");
        sqLiteDatabase.execSQL("drop table if exists course");
        sqLiteDatabase.execSQL("drop table if exists teacher_course");
        sqLiteDatabase.execSQL("drop table if exists meeting");
        sqLiteDatabase.execSQL("drop table if exists news");
        sqLiteDatabase.execSQL("drop table if exists system_notification");
        onCreate(sqLiteDatabase);
    }

    public int delete_user(String condition) {
        return this.mDB.delete(table_user, condition, (String[]) null);
    }

    public long insert_user(List<user> data) {
        long result = -1;
        for (int i = 0; i < data.size(); i++) {
            user u = data.get(i);
            ContentValues cv = new ContentValues();
            cv.put("user_name", u.getUser_name());
            cv.put("teacher_name", u.getTeacher_name());
            cv.put("user_nick_name", u.getUser_nick_name());
            cv.put("password", u.getPassword());
            cv.put("telephone_num", u.getTelephone_num());
            cv.put("personnel_signature", u.getPersonnel_signature());
            result = this.mDB.insert(table_user, "", cv);
            if (result == -1) {
                return result;
            }
        }
        return result;
    }

    public int update_user(user u, String condition) {
        ContentValues cv = new ContentValues();
        cv.put("user_name", u.getUser_name());
        cv.put("teacher_name", u.getTeacher_name());
        cv.put("user_nick_name", u.getUser_nick_name());
        cv.put("password", u.getPassword());
        cv.put("telephone_num", u.getTelephone_num());
        cv.put("personnel_signature", u.getPersonnel_signature());
        return this.mDB.update(table_user, cv, condition, (String[]) null);
    }

    public List<user> query_user(String condition) {
        String sql = String.format("select * from %s where %s", new Object[]{table_user, condition});
        List<user> data = new ArrayList<>();
        Cursor cursor = this.mDB.rawQuery(sql, (String[]) null);
        while (cursor.moveToNext()) {
            user u = new user();
            u.setUser_name(cursor.getString(0));
            u.setTeacher_name(cursor.getString(1));
            u.setUser_nick_name(cursor.getString(2));
            u.setPassword(cursor.getString(3));
            u.setTelephone_num(cursor.getString(4));
            u.setPersonnel_signature(cursor.getString(5));
            data.add(u);
        }
        cursor.close();
        return data;
    }

    public int delete_teacher(String condition) {
        return this.mDB.delete(table_teacher, condition, (String[]) null);
    }

    public long insert_teacher(List<teacher> data) {
        long result = -1;
        for (int i = 0; i < data.size(); i++) {
            teacher u = data.get(i);
            ContentValues cv = new ContentValues();
            cv.put("user_name", u.getUser_name());
            cv.put("teacher_name", u.getTeacher_name());
            cv.put("department", u.getDepartment());
            result = this.mDB.insert(table_teacher, "", cv);
            if (result == -1) {
                return result;
            }
        }
        return result;
    }

    public int update_teacher(teacher u, String condition) {
        ContentValues cv = new ContentValues();
        cv.put("user_name", u.getUser_name());
        cv.put("teacher_name", u.getTeacher_name());
        cv.put("department", u.getDepartment());
        return this.mDB.update(table_teacher, cv, condition, (String[]) null);
    }

    public List<teacher> query_teacher(String condition) {
        String sql = String.format("select * from %s where %s", new Object[]{table_teacher, condition});
        List<teacher> data = new ArrayList<>();
        Cursor cursor = this.mDB.rawQuery(sql, (String[]) null);
        while (cursor.moveToNext()) {
            teacher u = new teacher();
            u.setUser_name(cursor.getString(0));
            u.setTeacher_name(cursor.getString(1));
            u.setDepartment(cursor.getString(2));
            data.add(u);
        }
        cursor.close();
        return data;
    }

    public int delete_teach_and_research_section(String condition) {
        return this.mDB.delete(table_teach_and_research_section, condition, (String[]) null);
    }

    public long insert_teach_and_research_section(List<section> data) {
        long result = -1;
        for (int i = 0; i < data.size(); i++) {
            section u = data.get(i);
            ContentValues cv = new ContentValues();
            cv.put("id", u.getId());
            cv.put("name", u.getName());
            cv.put("group_leader_user_name", u.getGroup_leader());
            cv.put("course_id", u.getCourse_id());
            cv.put("department", u.getDepartment());
            result = this.mDB.insert(table_teach_and_research_section, "", cv);
            if (result == -1) {
                return result;
            }
        }
        return result;
    }

    public int update_teach_and_research_section(section u, String condition) {
        ContentValues cv = new ContentValues();
        cv.put("id", u.getId());
        cv.put("name", u.getName());
        cv.put("group_leader_user_name", u.getGroup_leader());
        cv.put("course_id", u.getCourse_id());
        cv.put("department", u.getDepartment());
        return this.mDB.update(table_teach_and_research_section, cv, condition, (String[]) null);
    }

    public List<section> query_teach_and_research_section(String condition) {
        String sql = String.format("select * from %s where %s", new Object[]{table_teach_and_research_section, condition});
        List<section> data = new ArrayList<>();
        Cursor cursor = this.mDB.rawQuery(sql, (String[]) null);
        while (cursor.moveToNext()) {
            section u = new section();
            u.setId(cursor.getString(0));
            u.setName(cursor.getString(1));
            u.setGroup_leader(cursor.getString(2));
            u.setCourse_id(cursor.getString(3));
            u.setDepartment(cursor.getString(4));
            data.add(u);
        }
        cursor.close();
        return data;
    }

    public int delete_section_user(String condition) {
        return this.mDB.delete(table_section_user, condition, (String[]) null);
    }

    public long insert_section_user(List<section_user> data) {
        long result = -1;
        for (int i = 0; i < data.size(); i++) {
            section_user u = data.get(i);
            ContentValues cv = new ContentValues();
            cv.put("id", u.getId());
            cv.put("user_name", u.getUser_name());
            result = this.mDB.insert(table_section_user, "", cv);
            if (result == -1) {
                return result;
            }
        }
        return result;
    }

    public int update_section_user(section_user u, String condition) {
        ContentValues cv = new ContentValues();
        cv.put("id", u.getId());
        cv.put("user_name", u.getUser_name());
        return this.mDB.update(table_section_user, cv, condition, (String[]) null);
    }

    public List<section_user> query_section_user(String condition) {
        String sql = String.format("select * from %s where %s", new Object[]{table_section_user, condition});
        List<section_user> data = new ArrayList<>();
        Cursor cursor = this.mDB.rawQuery(sql, (String[]) null);
        while (cursor.moveToNext()) {
            section_user u = new section_user();
            u.setId(cursor.getString(0));
            u.setUser_name(cursor.getString(1));
            data.add(u);
        }
        cursor.close();
        return data;
    }

    public int delete_course(String condition) {
        return this.mDB.delete(table_course, condition, (String[]) null);
    }

    public long insert_course(List<db_course> data) {
        long result = -1;
        for (int i = 0; i < data.size(); i++) {
            db_course u = data.get(i);
            ContentValues cv = new ContentValues();
            cv.put("course_id", u.getCourse_id());
            cv.put("course_name", u.getCourse_name());
            cv.put("course_introduction", u.getCourse_introduction());
            cv.put("department", u.getDepartment());
            result = this.mDB.insert(table_course, "", cv);
            if (result == -1) {
                return result;
            }
        }
        return result;
    }

    public int update_course(db_course u, String condition) {
        ContentValues cv = new ContentValues();
        cv.put("course_id", u.getCourse_id());
        cv.put("course_name", u.getCourse_name());
        cv.put("course_introduction", u.getCourse_introduction());
        cv.put("department", u.getDepartment());
        return this.mDB.update(table_course, cv, condition, (String[]) null);
    }

    public List<db_course> query_course(String condition) {
        String sql = String.format("select * from %s where %s", new Object[]{table_course, condition});
        List<db_course> data = new ArrayList<>();
        Cursor cursor = this.mDB.rawQuery(sql, (String[]) null);
        while (cursor.moveToNext()) {
            db_course u = new db_course();
            u.setCourse_id(cursor.getString(0));
            u.setCourse_name(cursor.getString(1));
            u.setCourse_introduction(cursor.getString(2));
            u.setDepartment(cursor.getString(3));
            data.add(u);
        }
        cursor.close();
        return data;
    }

    public int delete_teacher_course(String condition) {
        return this.mDB.delete(table_teacher_course, condition, (String[]) null);
    }

    public long insert_teacher_course(List<teacher_course> data) {
        long result = -1;
        for (int i = 0; i < data.size(); i++) {
            teacher_course u = data.get(i);
            ContentValues cv = new ContentValues();
            cv.put("user_name", u.getUser_name());
            cv.put("course_id", u.getCourse_id());
            result = this.mDB.insert(table_teacher_course, "", cv);
            if (result == -1) {
                return result;
            }
        }
        return result;
    }

    public int update_teacher_course(teacher_course u, String condition) {
        ContentValues cv = new ContentValues();
        cv.put("user_name", u.getUser_name());
        cv.put("course_id", u.getCourse_id());
        return this.mDB.update(table_teacher_course, cv, condition, (String[]) null);
    }

    public List<teacher_course> query_teacher_course(String condition) {
        String sql = String.format("select * from %s where %s", new Object[]{table_teacher_course, condition});
        List<teacher_course> data = new ArrayList<>();
        Cursor cursor = this.mDB.rawQuery(sql, (String[]) null);
        while (cursor.moveToNext()) {
            teacher_course u = new teacher_course();
            u.setUser_name(cursor.getString(0));
            u.setCourse_id(cursor.getString(1));
            data.add(u);
        }
        cursor.close();
        return data;
    }

    public int delete_meeting(String condition) {
        return this.mDB.delete(table_meeting, condition, (String[]) null);
    }

    public long insert_meeting(List<db_meeting> data) {
        long result = -1;
        for (int i = 0; i < data.size(); i++) {
            db_meeting u = data.get(i);
            ContentValues cv = new ContentValues();
            cv.put("id", u.getId());
            cv.put("invite_num", u.getInvite_num());
            cv.put("meeting_topic", u.getMeeting_topic());
            cv.put("user_name", u.getUser_name());
            cv.put("start_time", u.getStart_time());
            result = this.mDB.insert(table_meeting, "", cv);
            if (result == -1) {
                return result;
            }
        }
        return result;
    }

    public int update_meeting(db_meeting u, String condition) {
        ContentValues cv = new ContentValues();
        cv.put("id", u.getId());
        cv.put("invite_num", u.getInvite_num());
        cv.put("meeting_topic", u.getMeeting_topic());
        cv.put("user_name", u.getUser_name());
        cv.put("start_time", u.getStart_time());
        return this.mDB.update(table_meeting, cv, condition, (String[]) null);
    }

    public List<db_meeting> query_meeting() {
        String sql = String.format("select * from %s", new Object[]{table_meeting});
        List<db_meeting> data = new ArrayList<>();
        Cursor cursor = this.mDB.rawQuery(sql, (String[]) null);
        while (cursor.moveToNext()) {
            db_meeting u = new db_meeting();
            u.setId(cursor.getString(0));
            u.setInvite_num(cursor.getString(1));
            u.setMeeting_topic(cursor.getString(2));
            u.setUser_name(cursor.getString(3));
            u.setStart_time(cursor.getString(4));
            data.add(u);
        }
        cursor.close();
        return data;
    }

    public int delete_news(String condition) {
        return this.mDB.delete(table_news, condition, (String[]) null);
    }

    public long insert_news(List<news> data) {
        long result = -1;
        for (int i = 0; i < data.size(); i++) {
            news u = data.get(i);
            ContentValues cv = new ContentValues();
            cv.put("id", u.getId());
            cv.put("topic", u.getTopic());
            cv.put("content", u.getContent());
            cv.put("date", u.getDate());
            cv.put("publisher", u.getPublisher());
            result = this.mDB.insert(table_news, "", cv);
            if (result == -1) {
                return result;
            }
        }
        return result;
    }

    public int update_news(news u, String condition) {
        ContentValues cv = new ContentValues();
        cv.put("id", u.getId());
        cv.put("topic", u.getTopic());
        cv.put("content", u.getContent());
        cv.put("date", u.getDate());
        cv.put("publisher", u.getPublisher());
        return this.mDB.update(table_news, cv, condition, (String[]) null);
    }

    public List<news> query_news() {
        String sql = String.format("select * from %s", new Object[]{table_news});
        List<news> data = new ArrayList<>();
        Cursor cursor = this.mDB.rawQuery(sql, (String[]) null);
        while (cursor.moveToNext()) {
            news u = new news();
            u.setId(cursor.getString(0));
            u.setTopic(cursor.getString(1));
            u.setContent(cursor.getString(2));
            u.setDate(cursor.getString(3));
            u.setPublisher(cursor.getString(4));
            data.add(u);
        }
        cursor.close();
        return data;
    }

    public int delete_system_notification(String condition) {
        return this.mDB.delete(table_system_notification, condition, (String[]) null);
    }

    public long insert_system_notification(List<notification> data) {
        long result = -1;
        for (int i = 0; i < data.size(); i++) {
            notification u = data.get(i);
            ContentValues cv = new ContentValues();
            cv.put("id", u.getId());
            cv.put("topic", u.getTopic());
            cv.put("notification_type", u.getNotification_type());
            cv.put("content", u.getContent());
            cv.put("date", u.getDate());
            result = this.mDB.insert(table_system_notification, "", cv);
            if (result == -1) {
                return result;
            }
        }
        return result;
    }

    public int update_system_notification(notification u, String condition) {
        ContentValues cv = new ContentValues();
        cv.put("id", u.getId());
        cv.put("topic", u.getTopic());
        cv.put("notification_type", u.getNotification_type());
        cv.put("content", u.getContent());
        cv.put("date", u.getDate());
        return this.mDB.update(table_system_notification, cv, condition, (String[]) null);
    }

    public List<notification> query_system_notification() {
        String sql = String.format("select * from %s", new Object[]{table_system_notification});
        List<notification> data = new ArrayList<>();
        Cursor cursor = this.mDB.rawQuery(sql, (String[]) null);
        while (cursor.moveToNext()) {
            notification u = new notification();
            u.setId(cursor.getString(0));
            u.setTopic(cursor.getString(1));
            u.setNotification_type(cursor.getString(2));
            u.setContent(cursor.getString(3));
            u.setDate(cursor.getString(4));
            data.add(u);
        }
        cursor.close();
        return data;
    }
}
