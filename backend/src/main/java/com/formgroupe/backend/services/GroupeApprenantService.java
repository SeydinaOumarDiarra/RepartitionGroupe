package com.formgroupe.backend.services;

import com.formgroupe.backend.model.Groupe_apprenant;
import org.springframework.stereotype.Service;

@Service
public interface GroupeApprenantService {

    public Groupe_apprenant ajoutGroupeApprenant(Groupe_apprenant groupe_apprenant);

}
