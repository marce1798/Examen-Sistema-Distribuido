package o0pavel0o.buycars;
import o0pavel0o.buycars.*;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	//Invalidamos la cache //
		@CacheEvict(allEntries=true)
	
	Categoria findByTipoCategoria(String cat);


}
