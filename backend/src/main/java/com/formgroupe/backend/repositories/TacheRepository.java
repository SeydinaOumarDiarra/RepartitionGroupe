package com.formgroupe.backend.repositories;

import com.formgroupe.backend.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Long> {

    //recuperer les taches par liste
    @Query(value = "SELECT tch FROM Tache tch WHERE tch.liste.id = :id")
    List<Tache> getTacheByList(Long id);

}
