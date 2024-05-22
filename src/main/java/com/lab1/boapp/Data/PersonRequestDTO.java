package com.lab1.boapp.Data;

public class PersonRequestDTO {
    private String personNumber;
    private String userPersonNumber; // User's person number for authentication
    private String password; // User's password for authentication

    public PersonRequestDTO(){

    }

    public String getPassword() {
        return password;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public String getUserPersonNumber() {
        return userPersonNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
    }

    public void setUserPersonNumber(String userPersonNumber) {
        this.userPersonNumber = userPersonNumber;
    }
    // Getters and setters
}

