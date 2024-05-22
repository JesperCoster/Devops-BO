package com.lab1.boapp.BO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Person {
    private String personNumber;
    private String name;
    private Person mainDoctor;
    private String role;
    private String password;
    private ArrayList<Condition> conditions;
    private ArrayList<Message> messages;
    private ArrayList<Encounter> encounters;

    public Person(String personNumber, String name, Person mainDoctor, String role, String password){
        this.personNumber = personNumber;
        this.name = name;
        this.mainDoctor = mainDoctor;
        this.role = role;
        this.password = password;
        initArrays();
    }
    public Person(String personNumber, String name, Person mainDoctor, String role){
        this.personNumber = personNumber;
        this.name = name;
        this.mainDoctor = mainDoctor;
        this.role = role;
        initArrays();

    }

    private void initArrays(){
        this.conditions = new ArrayList<Condition>();
        this.messages = new ArrayList<Message>();
        this.encounters = new ArrayList<Encounter>();
    }

    public String getName() {
        return name;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public void setMainDoctor(Person mainDoctor) {
        this.mainDoctor = mainDoctor;
    }

    public Person getMainDoctor() {
        return mainDoctor;
    }
    public void addCondition(Condition newCondition){
        conditions.add(newCondition);
    }
    public Condition removeCondition(Condition conditionToRemove) {
        for (Iterator<Condition> iterator = conditions.iterator(); iterator.hasNext(); ) {
            Condition currentCondition = iterator.next();
            if (currentCondition.getName().equals(conditionToRemove.getName())) {
                iterator.remove(); // Remove the matching condition
                return currentCondition; // Return the removed condition
            }
        }
        return null; // Return null if the condition is not found
    }
    public void changeToInactive(String conditionName) {
        for (Condition condition : conditions) {
            if (condition.getName().equals(conditionName)) {
                condition.setActive(0); // Set the condition's active status to false (inactive)
                return; // Exit the loop once the condition is found and updated
            }
        }
    }
    public void changeToActive(String conditionName) {
        for (Condition condition : conditions) {
            if (condition.getName().equals(conditionName)) {
                condition.setActive(1); // Set the condition's active status to true (active)
                return; // Exit the loop once the condition is found and updated
            }
        }
    }

    public ArrayList<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(ArrayList<Condition> conditions) {
        this.conditions = conditions;
    }

    public ArrayList<Encounter> getEncounters() {
        return encounters;
    }

    public void setEncounters(ArrayList<Encounter> encounters) {
        this.encounters = encounters;
    }

    public String writeCondition()
    {
        return (conditions.get(0).getName());
    }
    public void addMessage(Message newMessage){
        messages.add(newMessage);
    }
    public void addEncounter(Encounter e){
        encounters.add(e);
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
}