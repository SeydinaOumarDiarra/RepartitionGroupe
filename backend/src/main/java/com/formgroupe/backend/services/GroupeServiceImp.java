package com.formgroupe.backend.services;

import com.formgroupe.backend.model.Groupe;
import com.formgroupe.backend.repositories.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupeServiceImp implements GroupeService{

    @Autowired
    GroupeRepository groupeRepository;

    @Override
    public Groupe ajoutGroupe(Groupe groupe) {
        return groupeRepository.save(groupe);
    }

    @Override
    public List<Groupe> listgroupe() {
        return groupeRepository.findAll();
    }

    @Override
    public void suppGroup(Long id) {
        groupeRepository.deleteById(id);
    }
<<<<<<< HEAD
=======

    @Override
    public List<Groupe> afficherGroupeParTache(Long id) {
        return groupeRepository.getGroupeByTaches(id);
    }
>>>>>>> be7c14c760b92bd14443d85abc2e82055efb62d0
}
