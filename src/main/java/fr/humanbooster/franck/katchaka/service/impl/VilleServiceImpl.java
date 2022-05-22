package fr.humanbooster.franck.katchaka.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.franck.katchaka.business.Ville;
import fr.humanbooster.franck.katchaka.dao.VilleDao;
import fr.humanbooster.franck.katchaka.service.VilleService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VilleServiceImpl implements VilleService {
	
	private final VilleDao villeDao;

	@Override
	public List<Ville> recupererVilles() {
		return villeDao.findAll();
	}

}
