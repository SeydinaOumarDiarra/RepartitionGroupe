package com.formgroupe.backend.controller;

import com.formgroupe.backend.model.Groupe;
import com.formgroupe.backend.services.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/repartition")
@CrossOrigin("*")
public class GroupeController {
    @Autowired
    GroupeService groupeService;

    @PostMapping("/ajoutGroupe")
    public Groupe ajoutgroupe(@RequestBody Groupe groupe){
        return groupeService.ajoutGroupe(groupe);
    }
}
