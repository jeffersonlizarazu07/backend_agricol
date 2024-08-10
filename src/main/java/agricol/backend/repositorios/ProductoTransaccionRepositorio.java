package agricol.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agricol.backend.entidades.ProductoinTransaccion;
@Repository
public interface ProductoTransaccionRepositorio extends JpaRepository<ProductoinTransaccion, Integer> {
    
}
