package com.lab1.boapp.BO;

import com.fasterxml.jackson.datatype.jsr310.deser.JSR310StringParsableDeserializer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Encounter {
    private int encounterId;
    private String patient;
    private String doctor;
    private String summary;
    private Date date;
    private ArrayList<Observation> observations;

    public Encounter(int encounterId, String patient, String doctor, String summary, Date date){
        this.encounterId = encounterId;
        this.patient = patient;
        this.doctor = doctor;
        this.summary = summary;
        this.date = date;
        this.observations = new ArrayList<>();
    }
    public Encounter(String patient, String doctor, String summary){
        this.patient = patient;
        this.doctor = doctor;
        this.summary = summary;
        this.date = new Date();
        this.observations = new ArrayList<>();
    }

    public String getSummary() {
        return summary;
    }

    public Date getDate() {
        return date;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getPatient() {
        return patient;
    }

    public void addObservation(Observation o){
        observations.add(o);
    }
}