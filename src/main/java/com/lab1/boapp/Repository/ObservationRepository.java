package com.lab1.boapp.Repository;

import com.lab1.boapp.Model.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservationRepository extends JpaRepository<Observation, Long> {
    // Custom query methods (if needed)
}
