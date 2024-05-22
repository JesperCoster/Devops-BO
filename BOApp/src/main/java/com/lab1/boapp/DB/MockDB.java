package com.lab1.boapp.DB;

import com.lab1.boapp.BO.Condition;
import com.lab1.boapp.BO.Encounter;
import com.lab1.boapp.BO.Message;
import com.lab1.boapp.BO.Person;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;

public class MockDB {
    private ArrayList<Message> messages = new ArrayList<>();
    private ArrayList<Message> conversations = new ArrayList<>();
    private  ArrayList<Person> persons = new ArrayList<>();
    private ArrayList<Encounter> encounters = new ArrayList<>();
    private static Person Doctor = new Person("20010211-3214", "Dr House"
            , null, "Doctor", "123456");
    private static Person Jesper = new Person("20010211-3214", "Jesper"
            , Doctor, "Patient", "123456");


    public MockDB(){

    }
    public static Person init(){
        return Jesper;
    }

    public boolean checkConnection() {
        String url = "jdbc:mysql://localhost:3306/web_shop_schema"; // Replace 'your_database' with your actual database name
        String username = "root";
        String password = "jepe2001";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("The connections is valid: " + connection.isValid(1));
            return connection.isValid(1); // Check if connection is valid
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Message> getConversations(String between, String and){
        if(conversations.size() == 0) {
            Message doctorMessage = new Message("Jesper ", "Doctor House", "You have canser");
            Message janitorMessage = new Message("Jesper ", "Janitor", "Now the floor is clean");
            conversations.add(doctorMessage);
            conversations.add(janitorMessage);
        }

        return conversations;
    }

    public ArrayList<Message> getMessages(String between, String and){
        if(messages.size() == 0) {
            Message doctorMessage = new Message("Doctor House ", "Jesper", "You have canser");
            Message patientMessage = new Message("Jesper", "Doctor House", "Oh no");
            Message doctorMessage2 = new Message("Doctor House ", "Jesper", "Get rekt ;)");

            messages.add(doctorMessage);
            messages.add(patientMessage);
            messages.add(doctorMessage2);
        }

        return messages;
    }

    public void sendMessage(String reciver,String message){
        Message newMessage = new Message("Jesper", reciver, message);
        messages.add(newMessage);
        System.out.println("THIS IS A TEST");
    }
    public static void addEncounter(Encounter e){
        Jesper.addEncounter(e);
    }
    public void addPerson(Person p){
        persons.add(p);
    }
    public static void addConditions(ArrayList<Condition> conditions) {
        for (Condition condition : conditions) {
            Jesper.addCondition(condition);
        }
    }


}
