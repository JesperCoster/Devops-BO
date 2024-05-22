package com.lab1.boapp.Service;

import com.lab1.boapp.Model.*;
import com.lab1.boapp.Repository.*;
import com.lab1.boapp.Model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private EncounterRepository encounterRepository;

    @Autowired
    private ObservationRepository observationRepository;

    @Autowired
    private ConditionRepository conditionRepository;

    @Autowired
    private PersonRepository personRepository;

    public void addPerson(Person newPerson) {
        personRepository.save(newPerson);
    }

    public Person getPerson(String personNumber) {
        return personRepository.findByPersonNumber(personNumber);
    }

    public Encounter addEncounter(Encounter e){
        encounterRepository.save(e);
        return e;
    }
    public Encounter getEncounter(){
        return null;
    }
    public Observation addObservation(Observation o){
        observationRepository.save(o);
        return o;
    }
    public Observation getObservation(){
        return null;
    }
    public Condition addCondition(Condition o){
        conditionRepository.save(o);
        return o;
    }
    public Condition getCondition(){
        return null;
    }
    public boolean validateUser(String personNumber, String password){
        Person personToValidate = personRepository.findByPersonNumber(personNumber);
        if(personNumber.equals(personToValidate.getPersonNumber())){
            if(password.equals(personToValidate.getPassword())){
                return true;
            }
        }
        return false;
    }
}
