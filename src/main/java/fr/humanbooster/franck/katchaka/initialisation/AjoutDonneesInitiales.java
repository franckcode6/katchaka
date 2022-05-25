package fr.humanbooster.franck.katchaka.initialisation;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import fr.humanbooster.franck.katchaka.business.Genre;
import fr.humanbooster.franck.katchaka.business.Interet;
import fr.humanbooster.franck.katchaka.business.Personne;
import fr.humanbooster.franck.katchaka.business.Statut;
import fr.humanbooster.franck.katchaka.business.Ville;
import fr.humanbooster.franck.katchaka.dao.GenreDao;
import fr.humanbooster.franck.katchaka.dao.InteretDao;
import fr.humanbooster.franck.katchaka.dao.PersonneDao;
import fr.humanbooster.franck.katchaka.dao.StatutDao;
import fr.humanbooster.franck.katchaka.dao.VilleDao;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

	private final GenreDao genreDao;
	private final InteretDao interetDao;
	private final PersonneDao personneDao;
	private final StatutDao statutDao;
	private final VilleDao villeDao;

	private List<Genre> genres;
	private List<Interet> interets;
	private List<Statut> statuts;
	private List<Ville> villes;

	private final Faker faker = new Faker(new Locale("fr-FR"));
	private static Random random = new Random();

	public void run(String... args) throws Exception {
		Date dateDebut = new Date();

		ajouterVilles();
		ajouterGenres();
		ajouterStatuts();
		ajouterInterets();
		ajouterPersonnes();

		Date dateFin = new Date();
		System.out.println("Données initiales générées en " + (dateFin.getTime() - dateDebut.getTime()) + " ms");
	}

	/**
	 * Ajout de villes par défaut en BDD au lancement de l'application
	 */
	private void ajouterVilles() {
		if (villeDao.count() == 0) {
			villes.add(new Ville("Nice"));
			villes.add(new Ville("Lyon"));
			villes.add(new Ville("Paris"));
			villes.add(new Ville("Marseille"));
			villes.add(new Ville("Rennes"));
			villes.add(new Ville("Lille"));
			villes.add(new Ville("Strasbourg"));
			villes.add(new Ville("Toulouse"));
			villes.add(new Ville("Montpellier"));
			villes.add(new Ville("Saint-Etienne"));
			villes.add(new Ville("Bordeaux"));
			villes.add(new Ville("Nantes"));
			villeDao.saveAll(villes);
		}
	}

	/**
	 * Ajout de genres pas défaut en BDD au lancement de l'application
	 */
	private void ajouterGenres() {
		if (genreDao.count() == 0) {
			genres.add(new Genre("Femme"));
			genres.add(new Genre("Homme"));
			genres.add(new Genre("Non binaire"));
			genreDao.saveAll(genres);
		}
	}

	/**
	 * Ajout de statuts par défaut en BDD au lancement de l'application
	 */
	private void ajouterStatuts() {
		if (statutDao.count() == 0) {
			statuts.add(new Statut("Célibataire"));
			statuts.add(new Statut("Séparé.e"));
			statuts.add(new Statut("Divorcé.e"));
			statuts.add(new Statut("Veuf.ve"));
			statutDao.saveAll(statuts);
		}
	}

	/**
	 * Ajout d'intérets par défaut en BDD au lancement de l'application
	 */
	private void ajouterInterets() {
		if (interetDao.count() == 0) {
			interets.add(new Interet("Pratiquer du sport"));
			interets.add(new Interet("Ecouter de la musique"));
			interets.add(new Interet("Lire"));
			interets.add(new Interet("Regarder des films/séries"));
			interets.add(new Interet("Se balader"));
			interets.add(new Interet("Voyager"));
			interets.add(new Interet("Cuisiner"));
			interets.add(new Interet("Bricoler"));
			interets.add(new Interet("Passer du temps entre amis"));
			interets.add(new Interet("Peindre/Dessiner"));
			interets.add(new Interet("Photographier"));
			interets.add(new Interet("Chiner"));
			interetDao.saveAll(interets);
		}
	}

	/**
	 * Ajout de personnes randoms par défaut en BDD au lancement de l'application
	 */
	private void ajouterPersonnes() {
		if (personneDao.count() == 0) {
			
			for (int i = 0; i < 500; i++) {
				// Attibution de 4 interets random pour chaque personne
				List<Interet> interetsPersonne = new ArrayList<>();
				for (int y = 1; y <= 4; y++) {
					interetsPersonne.add(interets.get(random.nextInt(interets.size())));
				}

				// Création et ajout d'une nouvelle personne en BDD
				personneDao.save(new Personne(faker.name().username(), faker.internet().emailAddress(),
						faker.internet().password(), faker.lorem().paragraph(),
						faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
						random.nextBoolean(), villes.get(random.nextInt(villes.size())),
						genres.get(random.nextInt(genres.size())), genres.get(random.nextInt(genres.size())),
						statuts.get(random.nextInt(statuts.size())), interetsPersonne));
			}

		}

	}

}
