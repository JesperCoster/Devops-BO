package com.lab1.boapp.Data;

public class CreatePersonDTO {
    private String personNumber;
    private String name;
    private String role;
    private String password;
    private String adminPersonNumber;
    private String adminPassword;

    // Getters and setters

    public String getPassword() {
        return password;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public String getAdminPersonNumber() {
        return adminPersonNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public void setAdminPersonNumber(String adminPersonNumber) {
        this.adminPersonNumber = adminPersonNumber;
    }

}

