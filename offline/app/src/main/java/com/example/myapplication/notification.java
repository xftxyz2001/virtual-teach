package com.example.myapplication;

public class notification {
    String content;
    String date;
    String id;
    String notification_type;
    String topic;

    public void setId(String id2) {
        this.id = id2;
    }

    public void setTopic(String topic2) {
        this.topic = topic2;
    }

    public void setNotification_type(String notification_type2) {
        this.notification_type = notification_type2;
    }

    public void setContent(String content2) {
        this.content = content2;
    }

    public void setDate(String date2) {
        this.date = date2;
    }

    public String getId() {
        return this.id;
    }

    public String getTopic() {
        return this.topic;
    }

    public String getNotification_type() {
        return this.notification_type;
    }

    public String getContent() {
        return this.content;
    }

    public String getDate() {
        return this.date;
    }
}
