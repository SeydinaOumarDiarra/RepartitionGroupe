package com.formgroupe.backend.controller;

import com.formgroupe.backend.model.Formateur;
import com.formgroupe.backend.services.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repartition")
@CrossOrigin("*")
public class FormateurController {

    //
    @Autowired
    FormateurService formateurService;

    @GetMapping("/loginAdmin/{login}/{passd}")
    public Formateur loginAdmin(@PathVariable String login, @PathVariable String passd){

        return formateurService.loginFormateur(login, passd);

    }

    @PostMapping("/ajoutFormateur")
    public Formateur ajoutFormateur(@RequestBody Formateur formateur){
        return formateurService.ajoutFormateur(formateur);
    }

    @GetMapping("/listeFormateur")
    public List<Formateur> listeFormateur(){
        return formateurService.listeFormateur();
    }

    @GetMapping("/formateur/{id}")
    public Formateur formateurById(@PathVariable Long id){
        return formateurService.formateurById(id);
    }

    @PutMapping("/miseAjourformateur/{id}")
    public void ajourFormateur(@PathVariable Long id, @RequestBody Formateur formateur){
        formateurService.miseAjourFormateur(id, formateur);
    }

    @DeleteMapping("/suppFormateur/{id}")
    public void supprimerFormateur(@PathVariable Long id){
        formateurService.supprimerFormateur(id);
    }

    @GetMapping("/verifiLogin/{login}")
    public Formateur verifiLogin(@PathVariable String login){
        return formateurService.loginFormateurVerifier(login);
    }

}
