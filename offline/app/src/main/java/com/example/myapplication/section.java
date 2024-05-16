package com.example.myapplication;

public class section {
    private String course_id;
    private String department;
    private String group_leader;
    private String id;
    private String name;

    public void setDepartment(String department2) {
        this.department = department2;
    }

    public void setCourse_id(String course_id2) {
        this.course_id = course_id2;
    }

    public void setGroup_leader(String group_leader2) {
        this.group_leader = group_leader2;
    }

    public void setId(String id2) {
        this.id = id2;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getDepartment() {
        return this.department;
    }

    public String getCourse_id() {
        return this.course_id;
    }

    public String getGroup_leader() {
        return this.group_leader;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
