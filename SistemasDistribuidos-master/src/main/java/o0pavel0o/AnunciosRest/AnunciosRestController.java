package o0pavel0o.AnunciosRest;

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
public class AnunciosRestController {

	private static final Logger log = LoggerFactory.getLogger(AnunciosRestController.class);

	@Autowired
	private AnunciosRestRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Collection<AnunciosRest> getBooks() {
		return repository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<AnunciosRest> getBook(@PathVariable long id) {

		log.info("Get book {}", id);

		AnunciosRest anunciosRest = repository.findOne(id);
		if (anunciosRest != null) {
			return new ResponseEntity<>(anunciosRest, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public AnunciosRest newBook(@RequestBody AnunciosRest anunciosRest) {

		repository.save(anunciosRest);

		return anunciosRest;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<AnunciosRest> updateBook(@PathVariable long id, @RequestBody AnunciosRest updatedBook) {

		AnunciosRest anunciosRest = repository.findOne(id);
		if (anunciosRest != null) {

			updatedBook.setId(id);
			repository.save(updatedBook);

			return new ResponseEntity<>(updatedBook, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<AnunciosRest> deleteBook(@PathVariable long id) {

		AnunciosRest deletedBook = repository.findOne(id);
		if (deletedBook != null) {
			repository.delete(id);
			return new ResponseEntity<>(deletedBook, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
