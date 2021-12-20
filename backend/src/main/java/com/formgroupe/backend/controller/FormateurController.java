package com.formgroupe.backend.controller;

import com.formgroupe.backend.model.Formateur;
import com.formgroupe.backend.services.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/repartition")
@CrossOrigin("*")
public class FormateurController {

    @Autowired
    FormateurService formateurService;

    @GetMapping("/loginAdmin/{login}&&{passd}")
    public Formateur loginAdmin(@PathVariable String login, @PathVariable String passd){

        return formateurService.loginFormateur(login, passd);

    }

}
