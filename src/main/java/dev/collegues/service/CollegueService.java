package dev.collegues.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.collegues.entite.Collegue;
import dev.collegues.exception.CollegueNonTrouveException;
import dev.collegues.modelJson.CollegueJson;
import dev.collegues.repository.CollegueRepository;
import dev.collegues.view.CollegueView;

@Service
public class CollegueService {

	private CollegueRepository collegueRepository;

	/**
	 * @param collegueRepository
	 */
	public CollegueService(CollegueRepository collegueRepository) {
		super();
		this.collegueRepository = collegueRepository;
	}

	public List<Collegue> liste() {
		return this.collegueRepository.findAll();
	}

	public List<String> listerCollegues(String nomReq) {

		return this.collegueRepository.findByNom(nomReq).stream().map(coll -> coll.getMatricule())
				.collect(Collectors.toList());

	}

	public CollegueView listerCollegueParMaricule(String matriculeReq) throws CollegueNonTrouveException {

		Optional<Collegue> optCollegue = this.collegueRepository.findByMatricule(matriculeReq);
		Collegue collegue = optCollegue.orElseThrow(() -> new CollegueNonTrouveException(""));
		return new CollegueView(collegue.getMatricule(), collegue.getNom(), collegue.getPrenoms(),
				collegue.getDateDeNaissance(), collegue.getPhotoUrl());

	}

	public void ajouterCollegue(CollegueJson collegueJson) {
		this.collegueRepository.save(new Collegue(UUID.randomUUID().toString(), collegueJson.getNom(),
				collegueJson.getPrenoms(), collegueJson.getPrenoms() + "." + collegueJson.getNom() + "@gmail.com",
				collegueJson.getDateDeNaissance(), collegueJson.getPhotoUrl()));
		ResponseEntity.status(HttpStatus.FOUND);
	}

	public void modifierPhotUrl(String matricule, String newPhotoUrl) throws CollegueNonTrouveException {
		this.collegueRepository.findByMatricule(matricule).orElseThrow(() -> new CollegueNonTrouveException(""));
		this.collegueRepository.modifierPhotoUrl(matricule, newPhotoUrl);
	}
}
