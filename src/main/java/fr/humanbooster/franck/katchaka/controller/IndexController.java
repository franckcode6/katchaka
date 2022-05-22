package fr.humanbooster.franck.katchaka.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

	@PostMapping("inscription")
	public ModelAndView inscriptionPost(@RequestParam("PSEUDO") String pseudo, @RequestParam("EMAIL") String email,
			@RequestParam("MOT_DE_PASSE") String motDePasse, @RequestParam("VILLE_ID") Long villeId,
			@RequestParam("GENRE_ID") Long genreId, @RequestParam("GENRE_RECHERCHE_ID") Long genreRechercheId,
			@RequestParam("STATUT_ID") Long statutId, @RequestParam("INTERET1") String interet,
			@RequestParam("BIO") String bio, @RequestParam("DATE_DE_NAISSANCE") String dateDeNaissance,
			@RequestParam(name = "FUMEUR", required = false) boolean estFumeur) {

		LocalDate date = LocalDate.parse(dateDeNaissance);

		personneService.ajouterPersonne(pseudo, email, motDePasse, bio, date, estFumeur,
				villeService.recupererVille(villeId), genreService.recupererGenre(genreId),
				genreService.recupererGenre(genreId), statutService.recupererStatut(statutId),
				interetService.ajouterInteret(interet));

		return new ModelAndView("redirect:/");
	}

}
