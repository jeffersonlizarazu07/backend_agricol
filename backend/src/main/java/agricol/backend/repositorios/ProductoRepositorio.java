package agricol.backend.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agricol.backend.entidades.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
    
}
