package com.formgroupe.backend.repositories;

import com.formgroupe.backend.model.Liste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListeRepository extends JpaRepository<Liste, Long> {

    //liste des listes par formateur
    @Query(value = "SELECT lst FROM Liste lst WHERE lst.formateur.id = :id")
    List<Liste> getListeByFormateur(Long id);

}
