package com.formgroupe.backend.services;


import com.formgroupe.backend.model.Formateur;
import org.springframework.stereotype.Service;

@Service
public interface FormateurService {

    public Formateur loginFormateur(String login, String passd);

}
