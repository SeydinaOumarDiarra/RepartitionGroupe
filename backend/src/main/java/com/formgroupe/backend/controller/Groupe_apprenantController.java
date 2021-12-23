package com.formgroupe.backend.controller;

import com.formgroupe.backend.model.Groupe_apprenant;
import com.formgroupe.backend.services.GroupeApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repartition")
@CrossOrigin("*")
public class Groupe_apprenantController {

    @Autowired
    GroupeApprenantService groupeApprenantService;

    @PostMapping("/ajoutGroupeApprenant")
    public Groupe_apprenant ajoutGroupeApprenant(@RequestBody Groupe_apprenant groupe_apprenant){
        return groupeApprenantService.ajoutGroupeApprenant(groupe_apprenant);
    }
    @GetMapping("/listeGroupeApprenant")
    public List<Groupe_apprenant> listGroupeApprenant(){
        return groupeApprenantService.listGroupeApprenant();
    }

    @GetMapping("/histoApprenant/{id}")
    public List<Groupe_apprenant> historiqueApprenant(Long id){
        return groupeApprenantService.histoGroupeApprenant(id);
    }

    @GetMapping("/histoGroupe/{id}")
    public List<Groupe_apprenant> historiqueGroupe(@PathVariable Long id){
        return groupeApprenantService.histoGroupeGroupe(id);
    }

}
