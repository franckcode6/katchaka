package fr.humanbooster.franck.katchaka.service;

import java.util.List;

import fr.humanbooster.franck.katchaka.business.Interet;

public interface InteretService {

	Interet ajouterInteret(String interet);

	Interet recupererInteret(String interet);

	Interet recupererInteret(Long interetID);
	
	List<Interet> recupererInterets();

}
