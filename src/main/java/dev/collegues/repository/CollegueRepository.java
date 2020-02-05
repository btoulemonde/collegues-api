package dev.collegues.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.collegues.entite.Collegue;

public interface CollegueRepository extends JpaRepository<Collegue, Integer> {

	List<Collegue> findByNom(String nom);

	Optional<Collegue> findByMatricule(String matricule);

	boolean existsByMatricule(String matricule);

}
