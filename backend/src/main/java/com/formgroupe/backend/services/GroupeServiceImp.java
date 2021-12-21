package com.formgroupe.backend.services;

import com.formgroupe.backend.model.Groupe;
import com.formgroupe.backend.repositories.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupeServiceImp implements GroupeService{

    @Autowired
    GroupeRepository groupeRepository;

    @Override
    public Groupe ajoutGroupe(Groupe groupe) {
        return groupeRepository.save(groupe);
    }
}
