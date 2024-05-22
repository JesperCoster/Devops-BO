package com.lab1.boapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab1.boapp.BO.*;
import com.lab1.boapp.DB.MockDB;
import com.lab1.boapp.Data.CombinedMessageDTO;
import com.lab1.boapp.Data.PersonRequestDTO;
import com.lab1.boapp.Model.Person;
import com.lab1.boapp.Model.Condition;
import com.lab1.boapp.Model.Encounter;
import com.lab1.boapp.Model.Observation;
import com.lab1.boapp.DB.MockIdentityDB;
import com.lab1.boapp.Model.Message;
import com.lab1.boapp.Data.Identity;
import com.lab1.boapp.Data.MessageDTO;
import com.lab1.boapp.Repository.UserRepository;
import com.lab1.boapp.Service.PersonService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    MockDB mockDB = new MockDB();
    MockIdentityDB identity = new MockIdentityDB();



    @Autowired
    private PersonService db;
    //TODO Update view and controller to check credentials
    @PostMapping("/")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> helloWorld(@RequestBody Identity credentials,
                                        @RequestParam String personNumber)
            throws JsonProcessingException {

        if (!db.validateUser(credentials.getPersonNumber(), credentials.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access");
        }

        System.out.println("The person number received is: " + personNumber);
        Person person = db.getPerson(personNumber.equals("-1") ? credentials.getPersonNumber() : personNumber);
        System.out.println(person.getName());

        ObjectMapper mapper = new ObjectMapper();
        String personJson = mapper.writeValueAsString(person);
        System.out.println("Person: " + personJson);

        return ResponseEntity.ok(person);
    }


    @Autowired
    private UserRepository userRepository;

    @GetMapping("/check-db-connection")
    @CrossOrigin(origins = "*")
    public boolean checkDatabaseConnection() {
        try {
            userRepository.count();
            System.out.println("HELLLLO" +  userRepository.count());
            return true; // Success implies the database connection is healthy
        } catch (Exception e) {
            return false; // An exception implies a problem with the database connection
        }
    }

    @PostMapping("/validateUser")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Identity> validateUser(@RequestBody Identity userToValidate) {
        String personnumber = userToValidate.getPersonNumber();
        String password = userToValidate.getPassword();

        if (db.validateUser(personnumber, password)) {
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("user", userToValidate); // Store user identity in session
            return ResponseEntity.ok(userToValidate);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/createPerson")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> createPerson(@RequestParam String personNumber,
                                               @RequestParam String name,
                                               @RequestParam String role,
                                               @RequestParam String password
                                               ) {

        if (false) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access");
        }

        System.out.println("The person that was created: \n" +
                "PersonNumberi: " + personNumber + "\n" +
                "Name: " + name + "\n" +
                "Role: " + role + "\n" +
                "Password: " + password);

        Person newPerson = new Person(personNumber, name, password, role);
        db.addPerson(newPerson);

        return ResponseEntity.ok("Person created successfully");
    }


    @PostMapping("/search")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> search(@RequestBody Identity credentials,
                                    @RequestParam String personNumber) {
        if (!db.validateUser(credentials.getPersonNumber(), credentials.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access");
        }

        System.out.println("The personNumber received is: " + personNumber);
        List<Person> list = new ArrayList<>();
        list.add(db.getPerson(personNumber));
        return ResponseEntity.ok(list);
    }
}