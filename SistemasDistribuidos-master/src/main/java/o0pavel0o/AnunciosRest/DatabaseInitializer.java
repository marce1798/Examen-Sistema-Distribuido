package o0pavel0o.AnunciosRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DatabaseInitializer implements CommandLineRunner {

	@Autowired
	private AnunciosRestRepository anunciosRestRepository;

	@Override
	public void run(String... args) throws Exception {

		anunciosRestRepository.save(new AnunciosRest("Maria", "Quiero vender mi coche BMW 320D"));
		anunciosRestRepository.save(new AnunciosRest("Maria", "Vendo Audi"));
		anunciosRestRepository.save(new AnunciosRest("Roberto", "Vendo Mercedes"));
		anunciosRestRepository.save(new AnunciosRest("4444", "44444"));
		

	}

}
