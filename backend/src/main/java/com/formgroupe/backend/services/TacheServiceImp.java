package com.formgroupe.backend.services;

import com.formgroupe.backend.model.Tache;
import com.formgroupe.backend.repositories.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TacheServiceImp implements TacheService{

    @Autowired
    TacheRepository tacheRepository;

    @Override
    public Tache ajoutTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    @Override
    public List<Tache> listeTache() {
        return tacheRepository.findAll();
    }

    @Transactional
    @Override
    public void modifierTache(Long id, Tache tache) {
        Tache tache1 = new Tache();
        tache1.setDescription(tache.getDescription());
    }

    @Override
    public void supprimerTache(Long id) {
        tacheRepository.deleteById(id);
    }
}
