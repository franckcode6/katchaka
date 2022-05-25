package fr.humanbooster.franck.katchaka.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.franck.katchaka.business.Ville;

public interface VilleDao extends JpaRepository<Ville, Long> {
	
	/**
	 * Liste les villes où il n'y pas d'inscrits
	 * @return
	 */
	List<Ville> findByPersonnesIsNull();

}
