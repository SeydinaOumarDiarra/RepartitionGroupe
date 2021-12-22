package com.formgroupe.backend.services;

import com.formgroupe.backend.model.Groupe;
import com.formgroupe.backend.repositories.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface GroupeService {

    public Groupe ajoutGroupe(Groupe groupe);
}