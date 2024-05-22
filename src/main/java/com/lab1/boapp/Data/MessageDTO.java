package com.lab1.boapp.Data;

public class MessageDTO {
    private String tooName;
    private String fromName;
    private String content;

    public String getTooName() {
        return tooName;
    }

    public String getFromName() {
        return fromName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public void setTooName(String tooName) {
        this.tooName = tooName;
    }
}
