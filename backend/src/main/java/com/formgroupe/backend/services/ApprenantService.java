package com.formgroupe.backend.services;


import com.formgroupe.backend.model.Apprenant;
import com.formgroupe.backend.model.Liste;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApprenantService {

    public void ajouterApprenant(Apprenant apprenant);

    public List<Apprenant> ajouterApprenants(List<Apprenant> apprenants);

    public List<Apprenant> listeApprenant();

    public void ajourApprenant(Long id, Apprenant apprenant);

    public List<Apprenant> listeApprenantdistinct(Long id);

}
