package com.formgroupe.backend.services;

import com.formgroupe.backend.model.Liste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ListeService {

    public Liste ajoutListe(Liste liste);

    public List<Liste> listeListe();

    public Liste listeById(Long id);

}
