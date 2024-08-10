package agricol.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agricol.backend.entidades.Rol;

@Repository
public interface RolRepositori extends JpaRepository<Rol, Integer> {
    
}
