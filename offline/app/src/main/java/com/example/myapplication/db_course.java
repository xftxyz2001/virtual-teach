package com.example.myapplication;

public class db_course {
    private String course_id;
    private String course_introduction;
    private String course_name;
    private String department;

    public String getCourse_id() {
        return this.course_id;
    }

    public String getDepartment() {
        return this.department;
    }

    public String getCourse_name() {
        return this.course_name;
    }

    public String getCourse_introduction() {
        return this.course_introduction;
    }

    public void setCourse_id(String course_id2) {
        this.course_id = course_id2;
    }

    public void setDepartment(String department2) {
        this.department = department2;
    }

    public void setCourse_name(String course_name2) {
        this.course_name = course_name2;
    }

    public void setCourse_introduction(String course_introduction2) {
        this.course_introduction = course_introduction2;
    }
}
