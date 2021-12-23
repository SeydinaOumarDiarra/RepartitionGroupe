package com.formgroupe.backend.services;

import com.formgroupe.backend.model.Groupe_apprenant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupeApprenantService {

    public Groupe_apprenant ajoutGroupeApprenant(Groupe_apprenant groupe_apprenant);

    public List<Groupe_apprenant> listGroupeApprenant();

    public List<Groupe_apprenant> histoGroupeApprenant(Long id);

    public List<Groupe_apprenant> histoGroupeGroupe(Long id);



}
