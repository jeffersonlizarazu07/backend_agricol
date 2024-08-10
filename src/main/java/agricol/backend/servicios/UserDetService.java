package agricol.backend.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import agricol.backend.entidades.Usuario;
import agricol.backend.exepciones.IdNotFoundException;
import agricol.backend.repositorios.UsuarioRepositorio;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetService implements UserDetailsService {

    @Autowired
    private final UsuarioRepositorio usuarioRepositories;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Usuario usuario = usuarioRepositories.findByEmail(email);
        if (usuario == null) {
            throw new IdNotFoundException("Usuario");
        }
        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getContrasena())
                .roles(usuario.getRol().getNombreRol().toString())
                .build();
    }

}
