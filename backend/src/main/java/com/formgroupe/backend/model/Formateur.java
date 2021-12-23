package com.formgroupe.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Formateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String login;
    private String password;
    @OneToMany(mappedBy = "formateur", cascade = CascadeType.ALL)
    private List<Groupe> groupes;
    @OneToMany(mappedBy = "formateur", cascade = CascadeType.ALL)
    private List<Liste> listes;


}
