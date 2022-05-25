package fr.humanbooster.franck.katchaka.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.humanbooster.franck.katchaka.business.Personne;

public interface PersonneDao extends JpaRepository<Personne, Long> {

	/**
	 * Liste les personnes par ville
	 * 
	 * @param ville
	 * @return
	 */
	List<Personne> findAllByVilleNom(String ville);

	/**
	 * Liste les personnes nées entre deux dates
	 * 
	 * @param dateDebut
	 * @param dateFin
	 * @return
	 */
	@Query("""
			SELECT p
			FROM Personne p
			WHERE p.dateDeNaissance >= :dateDebut and p.dateDeNaissance < :dateFin
			""")
	List<Personne> findAllByDayBetween(@Param("dateDebut") LocalDateTime dateDebut,
			@Param("dateFin") LocalDateTime dateFin);

	/**
	 * Liste les personnes célibataires de Lyon
	 * 
	 * @return
	 */
	@Query("""
			SELECT p.pseudo
			FROM Personne p
			WHERE p.ville.nom = 'Lyon' AND p.statut.nom = 'Célibataire'
						""")
	List<Personne> findSinglePersonsFromLyon();

	/**
	 * Compte le nombre d'inscrits par ville
	 * @return
	 */
	@Query("""
			SELECT p.ville.nom, COUNT(*)
			FROM Personne p
			GROUP BY p.ville.nom
						""")
	List<Personne> findPersonnesByVilles();

}
