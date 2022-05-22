package fr.humanbooster.franck.katchaka.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.franck.katchaka.business.Personne;

public interface PersonneDao extends JpaRepository<Personne, Long> {

}
