package dev.collegues.controller;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.collegues.entite.Collegue;
import dev.collegues.service.CollegueService;

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
	public List<Collegue> findMatriculesByNom(@Param("nom") String nomRequete) {
		return this.collegueService.listerCollegues(nomRequete);

	}

}
