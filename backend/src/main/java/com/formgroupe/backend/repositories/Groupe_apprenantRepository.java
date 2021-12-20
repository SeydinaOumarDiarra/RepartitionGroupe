package com.formgroupe.backend.repositories;

import com.formgroupe.backend.model.Groupe_apprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Groupe_apprenantRepository extends JpaRepository<Groupe_apprenant, Long> {
}
