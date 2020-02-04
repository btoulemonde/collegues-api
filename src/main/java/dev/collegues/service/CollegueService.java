package dev.collegues.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.collegues.repository.CollegueRepository;

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

	public List<String> listerCollegues(String nomReq) {

		return this.collegueRepository.findByNom(nomReq).stream().map(coll -> coll.getMatricule())
				.collect(Collectors.toList());

	}
}
