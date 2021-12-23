package com.formgroupe.backend.repositories;

import com.formgroupe.backend.model.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long> {

<<<<<<< HEAD
=======
    @Query(value = "SELECT grp FROM Groupe grp WHERE grp.tache.id = :id")
    List<Groupe> getGroupeByTaches(Long id);

>>>>>>> be7c14c760b92bd14443d85abc2e82055efb62d0
}