package com.formgroupe.backend.services;

import com.formgroupe.backend.model.Apprenant;
import com.formgroupe.backend.model.Liste;
import com.formgroupe.backend.repositories.ApprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApprenantServiceImp implements ApprenantService{

    @Autowired
    ApprenantRepository apprenantRepository;

    @Override
    public void ajouterApprenant(List<Apprenant> apprenant) {
       // List<Apprenant> list = new ArrayList<Apprenant>();
        for(int i=0; i< apprenant.size(); i++){
            //System.out.println(apprenant.get(i));
            Apprenant part = new Apprenant();
            //apprenantRepository.get
            part.setNom_complet(apprenant.get(i).getNom_complet());
            part.setEmail(apprenant.get(i).getEmail());
            part.setEmail(apprenant.get(i).getEmail());

            if (part.getEmail() != null && part.getNumero() != null){
                Apprenant aapprenant = apprenantRepository.getApprenantByListeAndEmailAndNumero(part.getListe(), part.getEmail(), part.getNumero());
                if (aapprenant == null) {
                    apprenantRepository.saveAndFlush(part);
                }else{
                    System.out.println("apprenant exist déjà dans la liste");
                }
            }else {
                System.out.println("error !!!!!!!!");
            }

            //Apprenant p = apprenantRepository.saveAndFlush(part);
            //list.add(p);
        }

    }

    @Override
    public List<Apprenant> listeApprenant() {
        return apprenantRepository.findAll();
    }

    @Override
    public List<Apprenant> listeApprenantdistinct(Liste liste) {
        return apprenantRepository.findApprenantByListe(liste);
    }
}
