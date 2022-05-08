package o0pavel0o.buycars;



import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })

@RequestMapping("/anuncios")
public class anuncioRestController {

	
	private static final Logger log = LoggerFactory.getLogger(anuncioRestController.class);

	@Autowired
	private AnunciosRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Collection<Anuncio> getBooks() {
		return repository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Anuncio> getBook(@PathVariable long id) {

		log.info("Get book {}", id);

		Anuncio anunciosRest = repository.findById(id);
		if (anunciosRest != null) {
			return new ResponseEntity<>(anunciosRest, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Anuncio newBook(@RequestBody Anuncio anunciosRest) {

		repository.save(anunciosRest);

		return anunciosRest;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Anuncio> updateBook(@PathVariable long id, @RequestBody Anuncio updatedBook) {

		Anuncio anunciosRest = repository.findById(id);
		if (anunciosRest != null) {

			updatedBook.setId(id);
			repository.save(updatedBook);

			return new ResponseEntity<>(updatedBook, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Anuncio> deleteBook(@PathVariable long id) {

		Anuncio deletedBook = repository.findById(id);
		if (deletedBook != null) {
			repository.delete(id);
			return new ResponseEntity<>(deletedBook, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
