package com.lab1.boapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Encounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long encounterId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Person patient; // Changed to Person entity

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Person doctor; // Changed to Person entity

    private String summary;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    private MedicalRecord medicalRecord;

    @OneToMany(mappedBy = "encounter", cascade = CascadeType.ALL)
    private List<Observation> observations;

    public Encounter() {
        // Default constructor
    }

    public Encounter(Person patient, Person doctor, String summary) {
        this.patient = patient;
        this.doctor = doctor;
        this.summary = summary;
        this.date = new Date();
    }

    // Getters and setters...

    public Person getDoctor() {
        return doctor;
    }

    public Person getPatient() {
        return patient;
    }

    public String getSummary() {
        return summary;
    }

    public Date getDate() {
        return date;
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public Long getEncounterId() {
        return encounterId;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPatient(Person patient) {
        this.patient = patient;
    }

    public void setDoctor(Person doctor) {
        this.doctor = doctor;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEncounterId(Long encounterId) {
        this.encounterId = encounterId;
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }
    // Existing getters and setters, modified for Person type

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }
}
