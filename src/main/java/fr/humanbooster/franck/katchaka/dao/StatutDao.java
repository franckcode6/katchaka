package fr.humanbooster.franck.katchaka.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.franck.katchaka.business.Statut;

public interface StatutDao extends JpaRepository<Statut, Long> {

}
