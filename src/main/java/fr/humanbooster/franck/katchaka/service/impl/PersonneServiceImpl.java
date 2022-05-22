package fr.humanbooster.franck.katchaka.service.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import fr.humanbooster.franck.katchaka.business.Genre;
import fr.humanbooster.franck.katchaka.business.Interet;
import fr.humanbooster.franck.katchaka.business.Personne;
import fr.humanbooster.franck.katchaka.business.Statut;
import fr.humanbooster.franck.katchaka.business.Ville;
import fr.humanbooster.franck.katchaka.dao.PersonneDao;
import fr.humanbooster.franck.katchaka.service.PersonneService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonneServiceImpl implements PersonneService {

	private final PersonneDao personneDao;

	public Personne ajouterPersonne(String pseudo, String email, String motDePasse, String bio, LocalDate dateDeNaissance,
			boolean fumeur, Ville ville, Genre genre, Genre genreRecherche, Statut statut, Interet interet) {
		Personne personne = personneDao.save(new Personne(pseudo, email, motDePasse, bio, dateDeNaissance, fumeur,
				ville, genre, genreRecherche, statut, interet));
		return personne;
	}

}
