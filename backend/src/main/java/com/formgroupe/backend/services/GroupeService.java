package com.formgroupe.backend.services;

import com.formgroupe.backend.model.Groupe;
import org.springframework.stereotype.Service;

@Service
public interface GroupeService {

    public Groupe ajoutGroupe(Groupe groupe);
}