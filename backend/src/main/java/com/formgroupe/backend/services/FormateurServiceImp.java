package com.formgroupe.backend.services;

import com.formgroupe.backend.model.Formateur;
import com.formgroupe.backend.repositories.FormateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormateurServiceImp implements FormateurService{

    @Autowired
    FormateurRepository formateurRepository;

    @Override
    public Formateur loginFormateur(String email, String login) {
        return formateurRepository.getFormateurByLoginAndPassword(email, login);
    }
}
