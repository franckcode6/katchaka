package fr.humanbooster.franck.katchaka.service.impl;

import org.springframework.stereotype.Service;

import fr.humanbooster.franck.katchaka.business.Interet;
import fr.humanbooster.franck.katchaka.dao.InteretDao;
import fr.humanbooster.franck.katchaka.service.InteretService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InteretServiceImpl implements InteretService {

	private final InteretDao interetDao;

	public Interet recupererInteret(String nom) {
		return interetDao.findByNom(nom);
	}

	@Override
	public Interet ajouterInteret(String nom) {
		if (recupererInteret(nom) != null) {
			return recupererInteret(nom);
		} else {
			Interet interet = interetDao.save(new Interet(nom));
			return interet;
		}

	}

}
