package com.lab1.boapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "conditions")
public class Condition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conditionId;

    private String name;
    private String summary;
    private boolean active;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "observation_id")
    private Observation observation;

    // Constructors, getters, setters...
    public Condition(long id, String name, String summary, int active) {
        this.conditionId = id;
        this.name = name;
        this.summary = summary;
        this.active = (active != 0);
    }
    public Condition(){

    }

    public Long getConditionId() {
        return conditionId;
    }

    public String getSummary() {
        return summary;
    }

    public String getName() {
        return name;
    }
    public boolean getActive(){
        return active;
    }
    public Observation getObservation() {
        return observation;
    }

    public void setConditionId(Long conditionId) {
        this.conditionId = conditionId;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setObservation(Observation observation) {
        this.observation = observation;
    }
}
