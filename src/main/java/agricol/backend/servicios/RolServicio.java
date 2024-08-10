package agricol.backend.servicios;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agricol.backend.dtos.req.RolRequest;
import agricol.backend.entidades.Rol;
import agricol.backend.repositorios.RolRepositori;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class RolServicio {

    @Autowired
    private RolRepositori rolRepositorio;

    public List<Rol> getAllRoles(){
        return rolRepositorio.findAll();
    }

    public Rol saveRol(RolRequest rolrequest){
        Rol rol = new Rol();
        BeanUtils.copyProperties(rolrequest,rol);
        return rolRepositorio.save(rol);
    }
    
}
