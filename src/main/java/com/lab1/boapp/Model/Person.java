package com.lab1.boapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String personNumber;
    private String name;
    private String role;
    @JsonIgnore
    private String password;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private MedicalRecord medicalRecord;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Encounter> encounters;

    // Assuming Person can be a doctor in Observations
    @OneToMany(mappedBy = "doctor")
    private List<Observation> doctorObservations;

    // Constructors, getters, setters...
    public Person(String personNumber, String name,String password, String role ){
        this.personNumber = personNumber;
        this.name = name;
        this.password = password;
        this.role = role;
    }
    public Person(){

    }

    // Existing getters and setters

    public String getPersonNumber() {
        return personNumber;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<Encounter> getEncounters() {
        return encounters;
    }

    public Long getId() {
        return id;
    }
    // Additional getters and setters for new relationships

    public List<Observation> getDoctorObservations() {
        return doctorObservations;
    }

    public void setDoctorObservations(List<Observation> doctorObservations) {
        this.doctorObservations = doctorObservations;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
