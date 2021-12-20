package com.formgroupe.backend.repositories;

import com.formgroupe.backend.model.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Long> {

    Formateur getFormateurByLoginAndPassword(String login, String passd);

}
