package agricol.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agricol.backend.entidades.Informe;

@Repository
public interface InformeRepositorio extends JpaRepository<Informe,Integer>{
    
}
