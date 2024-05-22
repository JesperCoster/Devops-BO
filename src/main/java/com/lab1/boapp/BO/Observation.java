package com.lab1.boapp.BO;

public class Observation {
    private String doctor;
    private String patient;
    private Condition condition;
    private String summary;

    public Observation(String doctor, String patient, Condition condition, String summary){
        this.doctor = doctor;
        this.patient = patient;
        this.condition = condition;
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getPatient() {
        return patient;
    }

    public Condition getCondition() {
        return condition;
    }
}