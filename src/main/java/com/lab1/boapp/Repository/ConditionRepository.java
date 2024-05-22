package com.lab1.boapp.Repository;

import com.lab1.boapp.Model.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Long> {
    // Custom query methods (if needed)
}
