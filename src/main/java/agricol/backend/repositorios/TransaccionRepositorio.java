package agricol.backend.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import agricol.backend.entidades.Transaccion;

@Repository
public interface TransaccionRepositorio extends JpaRepository<Transaccion, Integer> {
    
}
