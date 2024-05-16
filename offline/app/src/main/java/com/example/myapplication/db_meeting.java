package com.example.myapplication;

public class db_meeting {
    String id;
    String invite_num;
    String meeting_topic;
    String start_time;
    String user_name;

    public void setUser_name(String user_name2) {
        this.user_name = user_name2;
    }

    public void setInvite_num(String invite_num2) {
        this.invite_num = invite_num2;
    }

    public void setMeeting_topic(String meeting_topic2) {
        this.meeting_topic = meeting_topic2;
    }

    public void setId(String id2) {
        this.id = id2;
    }

    public void setStart_time(String start_time2) {
        this.start_time = start_time2;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public String getId() {
        return this.id;
    }

    public String getInvite_num() {
        return this.invite_num;
    }

    public String getMeeting_topic() {
        return this.meeting_topic;
    }

    public String getStart_time() {
        return this.start_time;
    }
}
