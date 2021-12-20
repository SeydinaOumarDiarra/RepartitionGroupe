package com.formgroupe.backend.repositories;

import com.formgroupe.backend.model.Liste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListeRepository extends JpaRepository<Liste, Long> {
}
