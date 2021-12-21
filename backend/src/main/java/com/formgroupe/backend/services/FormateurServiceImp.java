package com.formgroupe.backend.services;

import com.formgroupe.backend.model.Formateur;
import com.formgroupe.backend.repositories.FormateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FormateurServiceImp implements FormateurService{

    @Autowired
    FormateurRepository formateurRepository;

    @Override
    public Formateur loginFormateur(String email, String login) {
        return formateurRepository.getFormateurByLoginAndPassword(email, login);
    }

    @Override
    public Formateur loginFormateurVerifier(String login) {
        return formateurRepository.getFormateurByLogin(login);
    }

    @Override
    public Formateur ajoutFormateur(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    @Override
    public List<Formateur> listeFormateur() {
        return formateurRepository.findAll();
    }

    @Override
    @Transactional
    public void miseAjourFormateur(Long id, Formateur formateur) {
        Formateur formatrice = new Formateur();
        formatrice.setNom(formateur.getNom());
        formatrice.setPrenom(formateur.getPrenom());
        formatrice.setLogin(formateur.getLogin());
        formatrice.setPassword(formateur.getPassword());
    }

    @Override
    public Formateur formateurById(Long id) {
        return formateurRepository.findById(id).get();
    }

    @Override
    public void supprimerFormateur(Long id) {
        formateurRepository.deleteById(id);
    }
}
