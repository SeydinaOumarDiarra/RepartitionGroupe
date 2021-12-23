package com.formgroupe.backend.services;

import com.formgroupe.backend.model.Groupe_apprenant;
import com.formgroupe.backend.repositories.Groupe_apprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupeApprenantServiceImp implements GroupeApprenantService{

    @Autowired
    Groupe_apprenantRepository groupe_apprenantRepository;

    @Override
    public Groupe_apprenant ajoutGroupeApprenant(Groupe_apprenant groupe_apprenant) {

        return groupe_apprenantRepository.save(groupe_apprenant);
    }

    @Override
    public List<Groupe_apprenant> listGroupeApprenant() {
        return groupe_apprenantRepository.findAll();
    }

    @Override
    public List<Groupe_apprenant> histoGroupe(Long id) {
        return groupe_apprenantRepository.getGroupeApprenantByList(id);
    }
}
