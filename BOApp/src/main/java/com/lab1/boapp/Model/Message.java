package com.lab1.boapp.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private Person sender;
    private String fromName;

    @ManyToOne
    @JoinColumn(name = "recipient_id", nullable = false)
    private Person recipient;
    private String tooName;

    private String content;

    private Date sentAt;

    // Constructors
    public Message() {
    }

    public Message(Person sender, Person recipient, String content, Date sentAt) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.sentAt = sentAt;
        this.fromName = sender.getName();
        this.tooName = recipient.getName();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public Person getRecipient() {
        return recipient;
    }

    public void setRecipient(Person recipient) {
        this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSentAt() {
        return sentAt;
    }

    public void setSentAt(Date sentAt) {
        this.sentAt = sentAt;
    }
}
