package com.example.hopital_act2_p2;

import com.example.hopital_act2_p2.entities.*;
import com.example.hopital_act2_p2.repositories.ConsultationRepository;
import com.example.hopital_act2_p2.repositories.MedcinRepository;
import com.example.hopital_act2_p2.repositories.PatientRepository;
import com.example.hopital_act2_p2.repositories.RendezVousRepository;
import com.example.hopital_act2_p2.service.IHopitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HopitalAct2P2Application {

    public static void main(String[] args) {
        SpringApplication.run(HopitalAct2P2Application.class, args);
    }

    @Bean //methode Bean -> execute au demarage & return objet qui devient composant spring
    //mieux que implementer ComandLineRunner au debut car cela permet injecter dans methode start() ex start(PatientRepository patientRepository sans injectiondes dependances @Autowired)
    //injecter la couche service directement 'interface'
    CommandLineRunner start(IHopitalService hopitalService,
                            PatientRepository patientRepository,            //gerer cas findbyid sinn redifinir dans hopitalservice
                            RendezVousRepository rendezVousRepository,      //meme chose
                            MedcinRepository medcinRepository) {            //meme chose
        return args -> {
            Stream.of("Mohamed", "Hassan", "Najat")
                    .forEach(name->{
                        Patient patient=new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hopitalService.savePatient(patient);
                    });
            Stream.of("Ayman", "Hanane", "Yassmine")
                    .forEach(name->{
                        Medcin medcin=new Medcin();
                        medcin.setNom(name);
                        medcin.setEmail(name+"@gmail.com");
                        medcin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        hopitalService.saveMedcin(medcin);
                    });
            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByNom("Mohamed");

            Medcin medcin=medcinRepository.findByNom("Yassmine");

            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedcin(medcin);
            rendezVous.setPatient(patient);
            RendezVous savedRDV = rendezVousRepository.save(rendezVous);
            System.out.println(savedRDV.getId());

            //Pour avoir consultation il faut dabord un RDV donc ->

            RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());       // ou rendezVous.getDate pour avoir date du rdv
            consultation.setRendezVous(rendezVous1);            //rendezvous1 celui trouvez par findById
            consultation.setRapport("Rapport de la consultation .....");
            hopitalService.saveConsultation(consultation);
        };
    }
}
