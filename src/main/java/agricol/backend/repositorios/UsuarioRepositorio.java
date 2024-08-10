package agricol.backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agricol.backend.entidades.Usuario;



@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {
    public Usuario findByEmail(String email);
}
