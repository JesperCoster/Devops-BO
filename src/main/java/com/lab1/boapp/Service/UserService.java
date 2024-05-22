package com.lab1.boapp.Service;

import com.lab1.boapp.Model.User;
import com.lab1.boapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(String firstName, String lastName, String password) {
        User newUser = new User(firstName, lastName, password);
        return userRepository.save(newUser);
    }

    // Other business methods like saveUser, deleteUser, etc.
}
