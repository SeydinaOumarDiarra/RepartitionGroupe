package com.formgroupe.backend;

import com.formgroupe.backend.model.Formateur;
import com.formgroupe.backend.repositories.FormateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

		@Autowired
		FormateurRepository formateurRepository;
		public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Formateur formateur = new Formateur();

		formateur.setNom("Formateur");
		formateur.setPrenom("Admin");
		formateur.setLogin("admin");
		formateur.setPassword("1234");



		//ajouter administrateur par defaut
		formateurRepository.save(formateur);

	}
}
