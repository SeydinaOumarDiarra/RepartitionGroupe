package com.formgroupe.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Groupe {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom_groupe;
    @ManyToOne
    @JoinColumn(name = "tache_id")
    private Tache tache;
    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;
}
