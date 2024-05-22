package com.lab1.boapp.DB;

import com.lab1.boapp.BO.Person;

import java.util.ArrayList;

public class MockIdentityDB {
    ArrayList<Person> persons = new ArrayList<Person>();

    public MockIdentityDB(){
        Person Jesper = new Person("20010211-3214", "Jesper", null, "Doctor",
                "12345");
        persons.add(Jesper);

    }
    public void addPerson(Person newPerson) {
        persons.add(newPerson);
    }
    public boolean checkcheckIdentityWrap(String personNumber, String password){
        Person personToValidate = new Person(
                personNumber,
                "",
                null,
                "",
                password
        );

        boolean isValid = checkIdentity(personToValidate);

        return isValid;
    }

    // Method to check identity
    public boolean checkIdentity(Person personToCheck) {
        for (Person person : persons) {
            // Check if personNumber matches
            if (person.getPersonNumber().equals(personToCheck.getPersonNumber())) {
                // Check if password matches
                return person.getPassword().equals(personToCheck.getPassword());
            }
        }
        // Return false if no matching personNumber found or passwords don't match
        return false;
    }

    public Person getPerson(String personNumber) {
        for (Person person : persons) {
            // Check if personNumber matches
            if (person.getPersonNumber().equals(personNumber)) {
                // Check if password matches
                return person;
            }
        }
        // Return null if person does not exist
        return null;
    }

    public Boolean checkRole(String role, String personNumber){
        Person person = getPerson(personNumber);
        if(person != null){
            return (person.getRole().equals(role));
        }
        return false;
    }
    public ArrayList<Person> search(String personNumber){
        ArrayList<Person> foundPersons = new ArrayList<>();

        for (Person person : persons) {
            // Check if personNumber matches
            if (person.getPersonNumber().equals(personNumber)) {
                // Check if password matches
                foundPersons.add(person);
            }
        }
        return foundPersons;
    }
}
