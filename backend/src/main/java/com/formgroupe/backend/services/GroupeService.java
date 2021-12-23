package com.formgroupe.backend.services;

import com.formgroupe.backend.model.Groupe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupeService {

    public Groupe ajoutGroupe(Groupe groupe);
    public List<Groupe> listgroupe();
    public void suppGroup(Long id);
    public List<Groupe> afficherGroupeParTache(Long id);
}