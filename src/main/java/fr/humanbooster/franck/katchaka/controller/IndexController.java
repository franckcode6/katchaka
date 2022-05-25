package fr.humanbooster.franck.katchaka.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.franck.katchaka.business.Interet;
import fr.humanbooster.franck.katchaka.service.GenreService;
import fr.humanbooster.franck.katchaka.service.InteretService;
import fr.humanbooster.franck.katchaka.service.PersonneService;
import fr.humanbooster.franck.katchaka.service.StatutService;
import fr.humanbooster.franck.katchaka.service.VilleService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class IndexController {

	private final GenreService genreService;
	private final InteretService interetService;
	private final PersonneService personneService;
	private final StatutService statutService;
	private final VilleService villeService;

	/**
	 * Affichage de la page index
	 * 
	 * @return
	 */
	@GetMapping("/")
	public ModelAndView indexGet() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("index");

		return mav;
	}

	/**
	 * Affichage de la page d'inscription
	 * 
	 * @return
	 */
	@GetMapping("inscription")
	public ModelAndView inscriptionGet() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("villes", villeService.recupererVilles());
		mav.addObject("statuts", statutService.recupererStatuts());
		mav.addObject("genres", genreService.recupererGenres());

		mav.setViewName("inscription");

		return mav;
	}

	/**
	 * Ajout d'une nouvelle personne en BDD
	 * @param pseudo
	 * @param email
	 * @param motDePasse
	 * @param villeId
	 * @param genreId
	 * @param genreRechercheId
	 * @param statutId
	 * @param interet1
	 * @param interet2
	 * @param interet3
	 * @param interet4
	 * @param bio
	 * @param dateDeNaissance
	 * @param estFumeur
	 * @return
	 */
	@PostMapping("inscription")
	public ModelAndView inscriptionPost(@RequestParam("PSEUDO") String pseudo, @RequestParam("EMAIL") String email,
			@RequestParam("MOT_DE_PASSE") String motDePasse, @RequestParam("VILLE_ID") Long villeId,
			@RequestParam("GENRE_ID") Long genreId, @RequestParam("GENRE_RECHERCHE_ID") Long genreRechercheId,
			@RequestParam("STATUT_ID") Long statutId, @RequestParam("INTERET1") String interet1,
			@RequestParam(name = "INTERET2", required = false) String interet2,
			@RequestParam(name = "INTERET3", required = false) String interet3,
			@RequestParam(name = "INTERET4", required = false) String interet4, @RequestParam("BIO") String bio,
			@RequestParam("DATE_DE_NAISSANCE") String dateDeNaissance,
			@RequestParam(name = "FUMEUR", required = false) boolean estFumeur) {

		//Parsing de la date
		LocalDate date = LocalDate.parse(dateDeNaissance);

		//Création d'une liste d'interets
		//Si le champ n'est pas vide, on ajoute chaque Interet à la liste
		//On envoie le tout en BDD
		List<Interet> interets = new ArrayList<>();
		interets.add(new Interet(interet1));
		if (interet2 != "") {
			interets.add(new Interet(interet2));
		}
		if (interet2 != "") {
			interets.add(new Interet(interet3));
		}
		if (interet2 != "") {
			interets.add(new Interet(interet4));
		}
		interetService.ajouterInterets(interets);
		
		//Ajout de la personne en BDD
		//On récupère le tableau d'interets précédemment créé
		personneService.ajouterPersonne(pseudo, email, motDePasse, bio, date, estFumeur,
				villeService.recupererVille(villeId), genreService.recupererGenre(genreId),
				genreService.recupererGenre(genreId), statutService.recupererStatut(statutId), interets);

		return new ModelAndView("redirect:/");
	}

}
