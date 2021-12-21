package com.formgroupe.backend.controller;

import com.formgroupe.backend.model.Liste;
import com.formgroupe.backend.services.ListeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repartition")
@CrossOrigin("*")
public class ListeController {

    //injection de dependance
    @Autowired
    ListeService listeService;

    @PostMapping("ajoutListe")
    public Liste ajoutListe(@RequestBody Liste liste){
        return listeService.ajoutListe(liste);
    }

    @GetMapping("/listeListe")
    public List<Liste> listeListe(){
        return listeService.listeListe();
    }

    @GetMapping("/liste/{id}")
    public Liste listeListeId(@PathVariable Long id){
        return listeService.listeById(id);
    }

}
