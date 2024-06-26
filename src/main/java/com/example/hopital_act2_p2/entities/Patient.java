package com.example.hopital_act2_p2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
@Entity // si existe pas recharger les dependances
@Data @NoArgsConstructor @AllArgsConstructor

public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean malade;
    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY) //variable patient dans entities RendezVous
    private Collection<RendezVous> rendezVous; // collection car patient peut prendre plsrs rdv

}
