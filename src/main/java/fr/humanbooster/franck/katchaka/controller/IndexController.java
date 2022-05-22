package fr.humanbooster.franck.katchaka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class IndexController {
	
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
		
		mav.setViewName("inscription");
		
		return mav;
	}
	

}
