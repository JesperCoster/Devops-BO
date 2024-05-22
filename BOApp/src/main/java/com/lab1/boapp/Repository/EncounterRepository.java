package com.lab1.boapp.Repository;

import com.lab1.boapp.Model.Encounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncounterRepository extends JpaRepository<Encounter, Long> {
    // Custom query methods (if needed)
}
