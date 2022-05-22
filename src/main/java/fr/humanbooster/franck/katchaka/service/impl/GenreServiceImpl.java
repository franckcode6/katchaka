package fr.humanbooster.franck.katchaka.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.franck.katchaka.business.Genre;
import fr.humanbooster.franck.katchaka.dao.GenreDao;
import fr.humanbooster.franck.katchaka.service.GenreService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {

	private final GenreDao genreDao;

	public List<Genre> recupererGenres() {
		return genreDao.findAll();
	}

}
