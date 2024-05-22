package com.lab1.boapp.Data;

public class CombinedMessageDTO {
    private String personNumber;
    private String password;
    private MessageDTO messageDTO; // Embedded MessageDTO object

    // Getters and Setters for personNumber and password
    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getters and Setters for the MessageDTO object
    public MessageDTO getMessageDTO() {
        return messageDTO;
    }

    public void setMessageDTO(MessageDTO messageDTO) {
        this.messageDTO = messageDTO;
    }
}
