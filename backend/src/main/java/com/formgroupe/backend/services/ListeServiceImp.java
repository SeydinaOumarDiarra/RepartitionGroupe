package com.formgroupe.backend.services;

import com.formgroupe.backend.model.Liste;
import com.formgroupe.backend.repositories.ListeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ListeServiceImp implements ListeService{
    @Autowired
    ListeRepository listeRepository;

    @Override
    public Liste ajoutListe(Liste liste) {
        return listeRepository.save(liste);
    }
    @Override
    public List<Liste> listeListe() {
        return listeRepository.findAll();
    }

    @Override
    public Liste listeById(Long id) {
        return listeRepository.findById(id).get();
    }

    @Transactional
    @Override
    public void ajourListe(Long id, Liste liste) {
        Liste list = new Liste();
        list.setNom_liste(liste.getNom_liste());
    }

    @Override
    public void supprimerListe(Long id) {
        listeRepository.deleteById(id);
    }

    @Override
    public List<Liste> listeByFormateur(Long id) {
        return listeRepository.getListeByFormateur(id);
    }
}
