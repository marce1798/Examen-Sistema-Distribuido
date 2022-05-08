package o0pavel0o.buycars;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;


import o0pavel0o.*;

@CacheConfig(cacheNames="anuncios")
public interface AnunciosRepository extends JpaRepository<Anuncio, Long> {
    
	


	//Invalidamos la cache //
	@CacheEvict(allEntries=true)
	Anuncio save(Anuncio anuncio);

	@Cacheable
	Anuncio findByNombre(String nombre);
	
    
	
	@Cacheable
	Anuncio findById(Long id);
	
	Anuncio findByAsunto(String asunto);
	

	Anuncio findByNombreAndAsunto(String nombre, String asunto);
	
	
	
	
	
}