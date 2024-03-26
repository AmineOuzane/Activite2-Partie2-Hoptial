package com.example.hopital_act2_p2.repositories;

import com.example.hopital_act2_p2.entities.Medcin;
import com.example.hopital_act2_p2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedcinRepository extends JpaRepository<Medcin,Long> {
    Medcin findByNom(String nom);
}
