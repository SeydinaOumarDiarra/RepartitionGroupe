package com.formgroupe.backend.services;

import com.formgroupe.backend.model.Groupe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupeService {

    public Groupe ajoutGroupe(Groupe groupe);
    public List<Groupe> listgroupe();
    public void suppGroup(Long id);
<<<<<<< HEAD
=======
    public List<Groupe> afficherGroupeParTache(Long id);
>>>>>>> be7c14c760b92bd14443d85abc2e82055efb62d0
}