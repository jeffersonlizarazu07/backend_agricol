package agricol.backend.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import agricol.backend.dtos.req.RolRequest;
import agricol.backend.entidades.Rol;
import agricol.backend.servicios.RolServicio;


import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/Roles")
@AllArgsConstructor
public class RolControlador {

    @Autowired
    private final RolServicio rolServicio;

    @GetMapping
    public ResponseEntity<List<Rol>> getAlls() {
        return ResponseEntity.ok(this.rolServicio.getAllRoles());
    }

    @PostMapping("/Create")
    public ResponseEntity<Rol> saveRol(@RequestBody RolRequest rolRequest) {
        return ResponseEntity.ok(this.rolServicio.saveRol(rolRequest));
    }

}
