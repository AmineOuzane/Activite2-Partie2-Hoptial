package com.example.hopital_act2_p2.service;

import com.example.hopital_act2_p2.entities.Consultation;
import com.example.hopital_act2_p2.entities.Medcin;
import com.example.hopital_act2_p2.entities.Patient;
import com.example.hopital_act2_p2.entities.RendezVous;
import com.example.hopital_act2_p2.repositories.ConsultationRepository;
import com.example.hopital_act2_p2.repositories.MedcinRepository;
import com.example.hopital_act2_p2.repositories.PatientRepository;
import com.example.hopital_act2_p2.repositories.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service                // pour objet de couche metier
@Transactional          //
public class HopitalServiceImpl implements IHopitalService { // on a changer le nom de interface enlever le 1er I puis alt,entre pour confirmer changement de nom
    private PatientRepository patientRepository;
    private MedcinRepository medcinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    //ajout constructeur pour injection des dependences avec alt+entre de patientRepos , add constructor
    public HopitalServiceImpl(PatientRepository patientRepository, MedcinRepository medcinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medcinRepository = medcinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medcin saveMedcin(Medcin medcin) {
        return medcinRepository.save(medcin);
    }
    //Appliquer les regles metiers pour chaque methode si dispo si date dispo etc .....
    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
