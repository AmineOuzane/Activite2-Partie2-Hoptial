package com.example.hopital_act2_p2.repositories;

import com.example.hopital_act2_p2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String name); // si occurence de nom mieux faire une liste collection
}
