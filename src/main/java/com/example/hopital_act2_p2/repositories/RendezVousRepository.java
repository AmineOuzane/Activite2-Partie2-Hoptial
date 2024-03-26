package com.example.hopital_act2_p2.repositories;

import com.example.hopital_act2_p2.entities.Medcin;
import com.example.hopital_act2_p2.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
}
