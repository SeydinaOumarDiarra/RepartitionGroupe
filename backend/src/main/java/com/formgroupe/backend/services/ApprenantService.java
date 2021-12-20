package com.formgroupe.backend.services;


import com.formgroupe.backend.model.Apprenant;
import com.formgroupe.backend.model.Liste;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApprenantService {

    public void ajouterApprenant(List<Apprenant> apprenant);

    public List<Apprenant> listeApprenant();

    public List<Apprenant> listeApprenantdistinct(Liste liste);

}
