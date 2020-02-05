package dev.collegues.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.collegues.entite.Collegue;

public interface CollegueRepository extends JpaRepository<Collegue, Integer> {

	List<Collegue> findByNom(String nom);

	Optional<Collegue> findByMatricule(String matricule);

	boolean existsByMatricule(String matricule);

	@Query("Update Collegue c set c.photoUrl = :photoUrl where c.matricule = :matricule")
	@Modifying
	@Transactional
	void modifierPhotoUrl(@Param("matricule") String matricule, @Param("photoUrl") String newPhotoUrl);

	@Query("Update Collegue c set c.email = :email where c.matricule = :matricule")
	@Modifying
	@Transactional
	void modifierEmail(@Param("matricule") String matricule, @Param("email") String email);

}
