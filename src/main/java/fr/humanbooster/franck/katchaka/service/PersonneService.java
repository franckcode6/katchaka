package fr.humanbooster.franck.katchaka.service;

import java.time.LocalDate;
import java.util.List;

import fr.humanbooster.franck.katchaka.business.Genre;
import fr.humanbooster.franck.katchaka.business.Interet;
import fr.humanbooster.franck.katchaka.business.Personne;
import fr.humanbooster.franck.katchaka.business.Statut;
import fr.humanbooster.franck.katchaka.business.Ville;

public interface PersonneService {

	Personne ajouterPersonne(String pseudo, String email, String motDePasse, String bio, LocalDate dateDeNaissance,
			boolean fumeur, Ville ville, Genre genre, Genre genreRecherche, Statut statut, List<Interet> interets);

}
