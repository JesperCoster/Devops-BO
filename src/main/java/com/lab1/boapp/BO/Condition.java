package com.lab1.boapp.BO;

public class Condition {
    private int conditionId;
    private String name;
    private String summary;
    private int active;

    public Condition(int conditionId, String name, String summary, int active){
        this.conditionId = conditionId;
        this.name = name;
        this.summary = summary;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public int getActive() {
        return active;
    }

    public int getConditionId() {
        return conditionId;
    }

    public String getSummary() {
        return summary;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
