package com.example.hopital_act2_p2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class RendezVous {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @Enumerated(EnumType.STRING) // afficher dans BD en string 'PENDING.CANCELLED.DONE' et pas int '0.1.2'
    private StatusRDV status;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)      //eviter bcccp patient dans controller json
    private Patient patient;
    @ManyToOne
    private Medcin medcin;
    @OneToOne (mappedBy = "rendezVous") //mappedBy comme ForeignKey
    private Consultation consultation;
}
