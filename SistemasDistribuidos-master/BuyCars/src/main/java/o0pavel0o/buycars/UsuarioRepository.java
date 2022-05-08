package o0pavel0o.buycars;
import o0pavel0o.buycars.*;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

	Usuario findByNombre(String nombre);
	
	Usuario findByEmail(String emial);

}
