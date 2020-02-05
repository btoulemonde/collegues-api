package dev.collegues.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.collegues.entite.Collegue;
import dev.collegues.exception.CollegueNonTrouveException;
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
		if (!this.collegueRepository.existsByMatricule(matriculeReq)) {
			throw new CollegueNonTrouveException("");
		} else {
			Collegue collegue = this.collegueRepository.findByMatricule(matriculeReq);
			return new CollegueView(collegue.getMatricule(), collegue.getNom(), collegue.getPrenoms(),
					collegue.getDateDeNaissance(), collegue.getPhotoUrl());
		}
	}
}
