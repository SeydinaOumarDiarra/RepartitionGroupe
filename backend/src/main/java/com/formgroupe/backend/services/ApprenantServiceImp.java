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
    public void ajouterApprenant(Apprenant apprenant) {
        if (apprenant.getEmail() != null && apprenant.getNumero() != null){
            Apprenant aapprenant = apprenantRepository.getApprenantByListeAndEmailAndNumero(apprenant.getListe(), apprenant.getEmail(), apprenant.getNumero());
            if (aapprenant == null) {
                apprenantRepository.save(apprenant);
            }else{
                System.out.println("apprenant exist déjà dans la liste");
            }
        }else {
            System.out.println("error !!!!!!!!");
        }
    }

    @Override
    public List<Apprenant> ajouterApprenants(List<Apprenant> apprenants) {
        List<Apprenant> list = new ArrayList<>();
        for(int i=0; i< apprenants.size(); i++){
            Apprenant part = new Apprenant();
            part.setNom_complet(apprenants.get(i).getNom_complet());
            part.setEmail(apprenants.get(i).getEmail());
            part.setEmail(apprenants.get(i).getEmail());

            if (part.getEmail() != null || part.getNumero() != null){
                Apprenant aapprenant = apprenantRepository.getApprenantByListeAndEmailAndNumero(part.getListe(), part.getEmail(), part.getNumero());
                if (aapprenant == null) {
                    Apprenant p = apprenantRepository.saveAndFlush(part);
                    list.add(p);
                }else{
                    System.out.println("apprenant exist déjà dans la liste");
                }
            }else {
                System.out.println("error !!!!!!!!");
            }
        }
        return list;

    }

    @Override
    public List<Apprenant> listeApprenant() {
        return apprenantRepository.findAll();
    }

    @Override
    public List<Apprenant> listeApprenantdistinct(Long id) {
        return apprenantRepository.getApprenantByList(id);
    }
}
