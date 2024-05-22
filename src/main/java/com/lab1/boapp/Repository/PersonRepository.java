package com.lab1.boapp.Repository;

import com.lab1.boapp.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByPersonNumber(String personNumber);
}
