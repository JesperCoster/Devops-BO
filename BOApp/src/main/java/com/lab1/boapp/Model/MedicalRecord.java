package com.lab1.boapp.Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "person_id") // Optional but recommended
    private Person person;

    @OneToMany(mappedBy = "medicalRecord", cascade = CascadeType.ALL)
    private List<Encounter> encounters = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "medical_record_condition",
            joinColumns = @JoinColumn(name = "medical_record_id"),
            inverseJoinColumns = @JoinColumn(name = "condition_id")
    )
    private List<Condition> conditions = new ArrayList<>();

    // Constructors, getters, setters...

    public List<Condition> getConditions() {
        return conditions;
    }

    public List<Encounter> getEncounters() {
        return encounters;
    }

    public Person getPerson() {
        return person;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public void setEncounters(List<Encounter> encounters) {
        this.encounters = encounters;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    // Existing getters and setters
}
