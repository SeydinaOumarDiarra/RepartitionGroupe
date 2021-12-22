package com.formgroupe.backend.controller;

import com.formgroupe.backend.model.Apprenant;
import com.formgroupe.backend.model.Liste;
import com.formgroupe.backend.services.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repartition")
@CrossOrigin("*")
public class ApprenantController {

    @Autowired
    ApprenantService apprenantService;

    @PostMapping("/ajoutApprenant")
    public void ajouterApprenant(@RequestBody Apprenant apprenant){
        apprenantService.ajouterApprenant(apprenant);
    }

    @PostMapping("/ajoutApprenants")
    public List<Apprenant> ajouterApprenants(@RequestBody List<Apprenant> apprenants){
       return apprenantService.ajouterApprenants(apprenants);
    }

    @GetMapping("/listeApprenant")
    public List<Apprenant> listeApprenant(){
        return apprenantService.listeApprenant();
    }

    @PutMapping("/miseAjourApprennan/{id}")
    public void ajourApprenant(@PathVariable Long id, @RequestBody Apprenant apprenant){
        apprenantService.ajourApprenant(id, apprenant);
    }

    @GetMapping("/listeApprenantdistinct/{id}")
    public List<Apprenant> listeApprenant(@PathVariable Long id){
        return apprenantService.listeApprenantdistinct(id);
    }

    @DeleteMapping("/suppApprenant/{id}")
    public void supprimerApprenant(@PathVariable Long id){
        apprenantService.supprimerApprenant(id);
    }




}
