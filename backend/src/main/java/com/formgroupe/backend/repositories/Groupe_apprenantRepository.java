package com.formgroupe.backend.repositories;
import com.formgroupe.backend.model.Groupe_apprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Groupe_apprenantRepository extends JpaRepository<Groupe_apprenant, Long> {

    @Query(value = "SELECT ap FROM Groupe_apprenant ap WHERE apprenant_id = :id")
    List<Groupe_apprenant> getGroupeApprenantByList(Long id);

    @Query(value = "SELECT gap FROM Groupe_apprenant gap WHERE gap.groupe.id = :id")
    List<Groupe_apprenant> getGroupeApprenantByGroupe(Long id);

}
