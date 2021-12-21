package com.formgroupe.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Groupe_apprenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date_creation = LocalDate.now();
    @ManyToOne
    @JoinColumn(name = "apprenant_id")
    private Apprenant apprenant;
    @ManyToOne
    @JoinColumn(name = "groupe_id")
    private Groupe groupe;
}
