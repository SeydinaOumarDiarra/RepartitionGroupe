package com.formgroupe.backend.controller;

import com.formgroupe.backend.model.Tache;
import com.formgroupe.backend.services.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repartition")
@CrossOrigin("*")
public class TacheController {

    @Autowired
    TacheService tacheService;

    @PostMapping("/ajoutTache")
    public Tache ajoutTAche(Tache tache){
        return tacheService.ajoutTache(tache);
    }

    @GetMapping("/listeTache")
    public List<Tache> listeTache(){
        return tacheService.listeTache();
    }

    @PutMapping("/modifierTache/{id}")
    public void modifierTache(@PathVariable Long id, @RequestBody Tache tache){
        tacheService.modifierTache(id, tache);
    }


}
