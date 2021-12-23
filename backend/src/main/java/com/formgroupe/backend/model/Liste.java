package com.formgroupe.backend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Liste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom_liste;
    private LocalDate date_liste = LocalDate.now();
    @ManyToOne
    private Formateur formateur;
    @OneToMany(mappedBy = "liste", cascade = CascadeType.ALL)
    private List<Tache> taches;
    @OneToMany(mappedBy = "liste", cascade = CascadeType.ALL)
    private List<Apprenant> apprenants;
}
