package agricol.backend.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agricol.backend.entidades.UnidComercializacion;
import agricol.backend.repositorios.UnidadComercializacionRepositorio;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UnidadComercializacionServicio {

    @Autowired
    private UnidadComercializacionRepositorio unidadComercializacionRepositorio;

    public List<UnidComercializacion> getAllUnidadComercializacion(){
        return unidadComercializacionRepositorio.findAll();
    }
    
}
