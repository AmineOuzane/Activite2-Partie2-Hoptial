package com.example.hopital_act2_p2.repositories;

import com.example.hopital_act2_p2.entities.Consultation;
import com.example.hopital_act2_p2.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
