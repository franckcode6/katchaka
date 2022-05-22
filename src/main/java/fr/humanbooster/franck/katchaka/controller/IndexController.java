package fr.humanbooster.franck.katchaka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.franck.katchaka.service.GenreService;
import fr.humanbooster.franck.katchaka.service.StatutService;
import fr.humanbooster.franck.katchaka.service.VilleService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class IndexController {
	
	private final GenreService genreService;
	private final StatutService statutService;
	private final VilleService villeService;
	
	/**
	 * Affichage de la page index
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
	

}
