package com.formgroupe.backend.repositories;

import com.formgroupe.backend.model.Apprenant;
import com.formgroupe.backend.model.Liste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {

    //trouver un apprenant dans un liste donner
    Apprenant getApprenantByListeAndEmailAndNumero(Liste liste, String email, Integer numero);

    //liste des apprenant par liste
    @Query(value = "SELECT ap FROM Apprenant ap WHERE ap.liste.id = :id")
    List<Apprenant> getApprenantByList(Long id);

}
