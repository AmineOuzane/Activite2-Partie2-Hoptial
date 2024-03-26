package com.example.hopital_act2_p2.service;

import com.example.hopital_act2_p2.entities.Consultation;
import com.example.hopital_act2_p2.entities.Medcin;
import com.example.hopital_act2_p2.entities.Patient;
import com.example.hopital_act2_p2.entities.RendezVous;
import com.example.hopital_act2_p2.repositories.ConsultationRepository;

public interface IHopitalService {
     Patient savePatient(Patient patient);
     Medcin saveMedcin(Medcin medcin);
     RendezVous saveRendezVous(RendezVous rendezVous);
     Consultation saveConsultation(Consultation consultation);
}
