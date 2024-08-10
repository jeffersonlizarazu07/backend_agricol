package agricol.backend.servicios;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import agricol.backend.dtos.req.UsuarioRequest;
import agricol.backend.dtos.res.UsuarioResponse;
import agricol.backend.entidades.Rol;
import agricol.backend.entidades.Usuario;
import agricol.backend.exepciones.IdNotFoundException;
import agricol.backend.repositorios.RolRepositori;
import agricol.backend.repositorios.UsuarioRepositorio;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
@Transactional
public class UsuarioServicio implements ServicioAbstracto<UsuarioRequest, UsuarioResponse, Integer> {


    @Autowired
    private final UsuarioRepositorio usuariorepositorio;

    @Autowired
    private final RolRepositori rolRepositori;

    @Override
    public Page<UsuarioResponse> getAll(int page, int size) {
        PageRequest paginacion = PageRequest.of(page, size);
        Page<Usuario> usuarios = usuariorepositorio.findAll(paginacion);
        return usuarios.map(this::convertUsuarioToResponse);
    }

    @Override
    public UsuarioResponse create(UsuarioRequest request) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        String endodedPass = encoder.encode(request.getContrasena());
        Rol rol = rolRepositori.findById(request.getRolId()).orElseThrow(()-> new IdNotFoundException("rol"));
        Usuario usuario = convertUsuarioRequestToEntity(request, rol);
        usuario.setContrasena(endodedPass);
        Usuario usuarioCreado = usuariorepositorio.save(usuario);
        return convertUsuarioToResponse(usuarioCreado);
    }
    
    @Override
    public UsuarioResponse update(UsuarioRequest request, Integer id) {
        Rol rol = rolRepositori.findById(request.getRolId()).orElseThrow(()-> new IdNotFoundException("rol"));
        usuariorepositorio.findById(id).orElseThrow(()-> new IdNotFoundException("usuario"));
        Usuario usuario = convertUsuarioRequestToEntity(request, rol);
        Usuario usuarioCreado = usuariorepositorio.save(usuario);
        return convertUsuarioToResponse(usuarioCreado);
    }

    @Override
    public void delete(Integer id) {
        usuariorepositorio.findById(id).orElseThrow(()-> new IdNotFoundException("usuario"));
        usuariorepositorio.deleteById(id);
    }

    @Override
    public UsuarioResponse getById(Integer id) {
        Usuario usuario = usuariorepositorio.findById(id).orElseThrow(()-> new IdNotFoundException("usuario"));
        return convertUsuarioToResponse(usuario);
    }

    
//________________________________________________________
    private UsuarioResponse convertUsuarioToResponse(Usuario usuario) {
        UsuarioResponse response = new UsuarioResponse();
        BeanUtils.copyProperties(usuario, response);
        response.setRol(usuario.getRol());
        return response;
    }

    private Usuario convertUsuarioRequestToEntity(UsuarioRequest request, Rol rol){
        Usuario usuario = new Usuario();
        rol.setIdrol(request.getRolId());
        BeanUtils.copyProperties(request, usuario);
        usuario.setRol(rol);
        return usuario;
    }
}
