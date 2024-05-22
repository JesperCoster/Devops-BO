package com.lab1.boapp.BO;

import java.util.Date;

public class Message {
    private String fromName;
    private String tooName;
    private String content;
    private Date date;

    public Message(String from, String too, String content, Date date){
        this.fromName = from;
        this.tooName = too;
        this.content = content;
        this.date = date;
    }
    public Message(String from, String too, String content){
        this.fromName = from;
        this.tooName = too;
        this.content = content;
        this.date = new Date();
    }

    public String getContent() {
        return content;
    }

    public String getFromName() {
        return fromName;
    }

    public String getTooName() {
        return tooName;
    }
}