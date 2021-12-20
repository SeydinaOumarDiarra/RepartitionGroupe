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
    public void ajouterApprenant(@RequestBody List<Apprenant> apprenant){
        apprenantService.ajouterApprenant(apprenant);
    }
    @GetMapping("/listeApprenant")
    public List<Apprenant> listeApprenant(){
        return apprenantService.listeApprenant();
    }
    @GetMapping("/listeApprenantdistinct/{liste}")
    public List<Apprenant> listeApprenant(@PathVariable Liste liste){
        return apprenantService.listeApprenantdistinct(liste);
    }




}
