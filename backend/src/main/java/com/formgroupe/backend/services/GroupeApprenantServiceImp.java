package com.formgroupe.backend.services;

import com.formgroupe.backend.model.Groupe_apprenant;
import com.formgroupe.backend.repositories.Groupe_apprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupeApprenantServiceImp implements GroupeApprenantService{

    @Autowired
    Groupe_apprenantRepository groupe_apprenantRepository;

    @Override
    public Groupe_apprenant ajoutGroupeApprenant(Groupe_apprenant groupe_apprenant) {

        return groupe_apprenantRepository.save(groupe_apprenant);
    }
}
