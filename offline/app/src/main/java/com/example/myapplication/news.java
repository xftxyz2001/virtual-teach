package com.example.myapplication;

public class news {
    String content;
    String date;
    String id;
    String publisher;
    String topic;

    public void setId(String id2) {
        this.id = id2;
    }

    public void setContent(String content2) {
        this.content = content2;
    }

    public void setDate(String date2) {
        this.date = date2;
    }

    public void setPublisher(String publisher2) {
        this.publisher = publisher2;
    }

    public void setTopic(String topic2) {
        this.topic = topic2;
    }

    public String getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public String getDate() {
        return this.date;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getTopic() {
        return this.topic;
    }
}
