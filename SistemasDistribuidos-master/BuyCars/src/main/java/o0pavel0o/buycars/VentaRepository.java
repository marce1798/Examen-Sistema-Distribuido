package o0pavel0o.buycars;
import o0pavel0o.buycars.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta,Long> {
	
	Venta findById(Long nombre);

}
