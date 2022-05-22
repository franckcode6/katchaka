package fr.humanbooster.franck.katchaka.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.franck.katchaka.business.Statut;
import fr.humanbooster.franck.katchaka.dao.StatutDao;
import fr.humanbooster.franck.katchaka.service.StatutService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatutServiceImpl implements StatutService {
	
	private final StatutDao statutDao;

	@Override
	public List<Statut> recupererStatuts() {
		return statutDao.findAll();
	}

	@Override
	public Statut recupererStatut(Long id) {
		return statutDao.getById(id);
	}

}
