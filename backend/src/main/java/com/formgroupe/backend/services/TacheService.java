package com.formgroupe.backend.services;

import com.formgroupe.backend.model.Tache;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TacheService {

    public Tache ajoutTache(Tache tache);

    public List<Tache> listeTache();

    public void modifierTache(Long id, Tache tache);

    public void supprimerTache(Long id);


}
