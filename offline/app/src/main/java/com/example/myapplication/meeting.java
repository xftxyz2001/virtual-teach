package com.example.myapplication;

public class meeting {
    String meetingNum;
    String meetingTopic;
    String startDate;

    public String getMeetingTopic() {
        return this.meetingTopic;
    }

    public String getMeetingNum() {
        return this.meetingNum;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setMeetingTopic(String meetingTopic2) {
        this.meetingTopic = meetingTopic2;
    }

    public void setMeetingNum(String meetingNum2) {
        this.meetingNum = meetingNum2;
    }

    public void setStartDate(String startDate2) {
        this.startDate = startDate2;
    }
}
