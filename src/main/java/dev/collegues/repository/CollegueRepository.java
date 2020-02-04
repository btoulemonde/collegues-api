package dev.collegues.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.collegues.entite.Collegue;

public interface CollegueRepository extends JpaRepository<Collegue, Integer> {

	List<Collegue> findByNom(String nom);

}
