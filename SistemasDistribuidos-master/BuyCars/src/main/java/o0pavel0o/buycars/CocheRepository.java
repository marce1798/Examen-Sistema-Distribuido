package o0pavel0o.buycars;
import o0pavel0o.buycars.*;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;



@CacheConfig(cacheNames="coches")
public interface CocheRepository extends JpaRepository<Coche, Long>  {
	
	@CacheEvict(allEntries=true)
	Anuncio save(Anuncio anuncio);
	
	
	@Cacheable
	Coche findByMatricula(String matricula);
	
	@Cacheable
	Coche findById(Long id);
	
	@Cacheable
	Coche findByMarca(String marca);
	
}
