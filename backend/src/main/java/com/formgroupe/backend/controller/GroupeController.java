package com.formgroupe.backend.controller;

import com.formgroupe.backend.model.Groupe;
import com.formgroupe.backend.services.GroupeService;
import com.formgroupe.backend.services.ListeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/listGroupe")
    public List<Groupe> ListGroupe(){
        return groupeService.listgroupe();
    }
    @DeleteMapping("/suppGroupe/{id}")
    public void suppGroupe(@PathVariable Long id) {groupeService.suppGroup(id);}
}
