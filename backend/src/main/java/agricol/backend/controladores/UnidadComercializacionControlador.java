package agricol.backend.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import agricol.backend.entidades.UnidComercializacion;

import agricol.backend.servicios.UnidadComercializacionServicio;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/UnidadComercion")
@AllArgsConstructor
public class UnidadComercializacionControlador {

    @Autowired
    private final UnidadComercializacionServicio unidadComercializacionServicio;

    @GetMapping
    public ResponseEntity<List<UnidComercializacion>> getAllUnidades() {
        return ResponseEntity.ok(this.unidadComercializacionServicio.getAllUnidadComercializacion());
    }

}
