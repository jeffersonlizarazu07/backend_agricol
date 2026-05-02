package agricol.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agricol.backend.entidades.UnidComercializacion;

@Repository
public interface UnidadComercializacionRepositorio extends JpaRepository<UnidComercializacion, Integer> {

}
