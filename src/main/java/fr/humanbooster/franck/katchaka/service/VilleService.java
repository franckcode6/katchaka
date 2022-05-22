package fr.humanbooster.franck.katchaka.service;

import java.util.List;

import fr.humanbooster.franck.katchaka.business.Ville;

public interface VilleService {

	List<Ville> recupererVilles();

	Ville recupererVille(Long id);

}
