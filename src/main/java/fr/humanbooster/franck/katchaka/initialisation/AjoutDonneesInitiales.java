package fr.humanbooster.franck.katchaka.initialisation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import fr.humanbooster.franck.katchaka.business.Ville;
import fr.humanbooster.franck.katchaka.dao.VilleDao;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {
	
	private final VilleDao villeDao;
	
	public void run(String... args) throws Exception {
		ajouterVilles();
		
	}
	
	/**
	 * Ajout de villes par défaut en BDD au lancement de l'application
	 */
	private void ajouterVilles() {
		if (villeDao.count() == 0 ) {
			villeDao.save(new Ville("Nice"));
			villeDao.save(new Ville("Lyon"));
			villeDao.save(new Ville("Paris"));
			villeDao.save(new Ville("Marseille"));
			villeDao.save(new Ville("Rennes"));
			villeDao.save(new Ville("Lille"));
			villeDao.save(new Ville("Strasbourg"));
			villeDao.save(new Ville("Toulouse"));
			villeDao.save(new Ville("Montpellier"));
			villeDao.save(new Ville("Saint-Etienne"));
			villeDao.save(new Ville("Bordeaux"));
			villeDao.save(new Ville("Nantes"));
		}
	}

}
