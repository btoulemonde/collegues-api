package dev.collegues.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.collegues.entite.Collegue;

public interface CollegueRepository extends JpaRepository<Collegue, UUID> {

	List<Collegue> findByNom(String nom);

}
