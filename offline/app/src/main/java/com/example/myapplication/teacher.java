package com.example.myapplication;

public class teacher {
    private String department;
    private String teacher_name;
    private String user_name;

    public String getUser_name() {
        return this.user_name;
    }

    public String getTeacher_name() {
        return this.teacher_name;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setTeacher_name(String teacher_name2) {
        this.teacher_name = teacher_name2;
    }

    public void setUser_name(String user_name2) {
        this.user_name = user_name2;
    }

    public void setDepartment(String department2) {
        this.department = department2;
    }
}
