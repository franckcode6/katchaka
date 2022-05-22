package fr.humanbooster.franck.katchaka.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.franck.katchaka.business.Ville;

public interface VilleDao extends JpaRepository<Ville, Long> {

}
