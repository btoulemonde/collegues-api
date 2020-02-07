package dev.collegues.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.collegues.entite.Collegue;
import dev.collegues.exception.CollegueNonTrouveException;
import dev.collegues.modelJson.CollegueJson;
import dev.collegues.modelJson.ColleguePhotUrlJson;
import dev.collegues.service.CollegueService;
import dev.collegues.view.CollegueView;

@CrossOrigin
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
	public CollegueView reqMatricule(@PathVariable String matricule) throws CollegueNonTrouveException {
		return this.collegueService.listerCollegueParMaricule(matricule);
	}

	@PostMapping
	public void ajouterCollegue(@RequestBody @Valid CollegueJson collegueJson) {
		this.collegueService.ajouterCollegue(collegueJson);
	}

	@PatchMapping(path = "{matricule}")
	@ResponseBody
	public void modifPhotUrl(@PathVariable String matricule,
			@RequestBody @Valid ColleguePhotUrlJson colleguePhotUrlJson) throws CollegueNonTrouveException {
		if (colleguePhotUrlJson.getPhotoUrl() != null) {
			String photoUrl = colleguePhotUrlJson.getPhotoUrl();
			this.collegueService.modifierPhotUrl(matricule, photoUrl);
		}
		if (colleguePhotUrlJson.getEmail() != null) {
			String email = colleguePhotUrlJson.getEmail();
			this.collegueService.modifierEmail(matricule, email);
		}

	}

	@GetMapping(params = "email")
	public boolean existsByEmail(@RequestParam("email") String email) {
		return this.collegueService.existsByEmail(email);
	}

}
