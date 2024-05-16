package com.example.myapplication;

public class user {
    private String password;
    private String personnel_signature;
    private String teacher_name;
    private String telephone_num;
    private String user_name;
    private String user_nick_name;

    public void setTeacher_name(String teacher_name2) {
        this.teacher_name = teacher_name2;
    }

    public void setPassword(String password2) {
        this.password = password2;
    }

    public void setTelephone_num(String telephone_num2) {
        this.telephone_num = telephone_num2;
    }

    public void setUser_name(String user_name2) {
        this.user_name = user_name2;
    }

    public void setUser_nick_name(String user_nick_name2) {
        this.user_nick_name = user_nick_name2;
    }

    public String getTeacher_name() {
        return this.teacher_name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getTelephone_num() {
        return this.telephone_num;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public String getUser_nick_name() {
        return this.user_nick_name;
    }

    public String getPersonnel_signature() {
        return this.personnel_signature;
    }

    public void setPersonnel_signature(String personnel_signature2) {
        this.personnel_signature = personnel_signature2;
    }
}
