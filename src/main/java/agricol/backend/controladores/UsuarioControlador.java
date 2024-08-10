package agricol.backend.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import agricol.backend.dtos.req.UsuarioRequest;
import agricol.backend.dtos.res.UsuarioResponse;
import agricol.backend.servicios.UsuarioServicio;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/Usuarios")
@AllArgsConstructor
public class UsuarioControlador {

    @Autowired
    private final UsuarioServicio usuarioServicio;

    @GetMapping
    public ResponseEntity<Page<UsuarioResponse>> getAllUsers(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(this.usuarioServicio.getAll(page - 1, size));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> postMethodName(@RequestBody @Validated UsuarioRequest request) {      
        UsuarioResponse response = usuarioServicio.create(request);
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> putMethodName(@PathVariable int id, @RequestBody @Validated UsuarioRequest request){
        UsuarioResponse response = usuarioServicio.update(request, id);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> getMethodUsingId(@PathVariable int id) {
        return ResponseEntity.ok(usuarioServicio.getById(id));
    }

    
}
