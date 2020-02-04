package dev.collegues.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.collegues.entite.Collegue;
import dev.collegues.service.CollegueService;
import dev.collegues.view.CollegueView;

@RestController
@RequestMapping("collegues")
public class CollegueController {

	private CollegueService collegueService;

	/**
	 * @param collegueService
	 */
	public CollegueController(CollegueService collegueService) {
		super();
		this.collegueService = collegueService;
	}

	@GetMapping
	public List<Collegue> lister() {
		return this.collegueService.liste();
	}

	@GetMapping(params = "nom")
	public List<String> findMatriculesByNom(@RequestParam("nom") String nomRequete) {
		return this.collegueService.listerCollegues(nomRequete);

	}

	@GetMapping(path = "{matricule}")
	@ResponseBody
	public CollegueView reqMatricule(@PathVariable String matricule) {
		return this.collegueService.listerCollegueParMaricule(matricule);
	}

}
