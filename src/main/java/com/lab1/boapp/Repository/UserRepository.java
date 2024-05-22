package com.lab1.boapp.Repository;

import com.lab1.boapp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query methods
    List<User> findByFirstName(String firstName);
    List<User> findByLastNameOrderByFirstNameAsc(String lastName);
    long countByLastName(String lastName);

    // Example of using @Query annotation for a custom query
    @Query("SELECT usr FROM User usr WHERE usr.firstName = ?1")
    List<User> findUsersWithFirstName(String firstName);

    //@Query("SELECT * FROM User")
    //List<User> findAll(String firstName);
}