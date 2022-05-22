package fr.humanbooster.franck.katchaka.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.franck.katchaka.business.Genre;

public interface GenreDao extends JpaRepository<Genre, Long>{

}
