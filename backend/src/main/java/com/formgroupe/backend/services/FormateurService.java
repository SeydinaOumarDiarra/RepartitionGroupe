package com.formgroupe.backend.services;


import com.formgroupe.backend.model.Formateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FormateurService {

    public Formateur loginFormateur(String login, String passd);

    public Formateur loginFormateurVerifier(String login);

    public Formateur ajoutFormateur(Formateur formateur);

    public List<Formateur> listeFormateur();

    public void miseAjourFormateur(Long id, Formateur formateur);

    public Formateur formateurById(Long id);

    public void supprimerFormateur(Long id);

}
