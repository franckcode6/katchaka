package fr.humanbooster.franck.katchaka.service;

import java.util.List;

import fr.humanbooster.franck.katchaka.business.Interet;

public interface InteretService {

	List<Interet> ajouterInterets(List<Interet> interets);

	Interet recupererInteret(Long interetID);

	List<Interet> recupererInterets();

}
