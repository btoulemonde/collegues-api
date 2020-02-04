package dev.collegues;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.collegues.entite.Collegue;
import dev.collegues.repository.CollegueRepository;

@Component
public class Startup {
	private static final Logger LOG = LoggerFactory.getLogger(Startup.class);

	private CollegueRepository collegueRepository;

	/**
	 * @param collegueRepository
	 */
	public Startup(CollegueRepository collegueRepository) {
		super();
		this.collegueRepository = collegueRepository;
	}

	@EventListener(ContextRefreshedEvent.class)

	public void init() {

		LOG.info("Démarrage de l'application");

		if (this.collegueRepository.count() == 0) {

			List<Collegue> collegues = new ArrayList<Collegue>();
			collegues.add(new Collegue(UUID.randomUUID().toString(), "Picasso", "Pablo", "pablo.picasso@gmail.com",
					LocalDate.of(1900, 10, 05), "http://www.w3schools.com/bootstrap/img_avatar3.png"));
			collegues.add(new Collegue(UUID.randomUUID().toString(), "Hugo", "Victor", "victor.hugo@gmail.com",
					LocalDate.of(1900, 10, 05), "http://www.w3schools.com/bootstrap/img_avatar3.png"));
			collegues.add(new Collegue(UUID.randomUUID().toString(), "Chan", "Jacky", "chan.jacky@gmail.com",
					LocalDate.of(1900, 10, 05), "http://www.w3schools.com/bootstrap/img_avatar3.png"));
			this.collegueRepository.saveAll(collegues);

		}
	}
}