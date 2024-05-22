package com.lab1.boapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Person doctor;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Person patient;

    @JsonIgnore
    @ManyToOne
    private Encounter encounter;

    @OneToMany(mappedBy = "observation", cascade = CascadeType.ALL)
    private List<Condition> conditions;

    private String summary;

    // Constructors, getters, setters...
    public Observation(Person doctor, Person patient, List<Condition> conditions, String summary) {
        this.doctor = doctor;
        this.patient = patient;
        this.conditions = conditions;
        this.summary = summary;
        this.conditions = new ArrayList<>();
    }
    public Observation(){

    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public Person getPatient() {
        return patient;
    }

    public Person getDoctor() {
        return doctor;
    }

    public String getSummary() {
        return summary;
    }

    public Encounter getEncounter() {
        return encounter;
    }

    public Long getId() {
        return id;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDoctor(Person doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Person patient) {
        this.patient = patient;
    }

    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
    }
}
