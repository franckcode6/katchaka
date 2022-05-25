package fr.humanbooster.franck.katchaka.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.franck.katchaka.business.Interet;
import fr.humanbooster.franck.katchaka.dao.InteretDao;
import fr.humanbooster.franck.katchaka.service.InteretService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InteretServiceImpl implements InteretService {

	private final InteretDao interetDao;
	
	public List<Interet> recupererInterets() {
		return interetDao.findAll();
	}
	
	public List<Interet> ajouterInterets(List<Interet> interets) {
		return interetDao.saveAll(interets);
	}

	@Override
	public Interet recupererInteret(Long id) {
		return interetDao.findById(id).orElse(null);
	}

}
