package agricol.backend.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import agricol.backend.dtos.req.InicioSesionReq;
import agricol.backend.dtos.req.UsuarioRequest;
import agricol.backend.dtos.res.UsuarioResponse;
import agricol.backend.servicios.ServicioDeSeguridad;
import agricol.backend.servicios.UsuarioServicio;
import lombok.AllArgsConstructor;


import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor

public class AutorizadorControlador {

    @Autowired
    @Lazy
    private ServicioDeSeguridad servicio;

    @PostMapping("/jwt")

    public ResponseEntity<Void> inicioSeSion(@RequestBody @Validated InicioSesionReq request) {
        String jwt = servicio.login(request);
        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwt).build();
    }

    @Autowired
    private final UsuarioServicio usuarioServicio;

    @PostMapping("/new")
    public ResponseEntity<UsuarioResponse> postMethodName(@RequestBody @Validated UsuarioRequest request) {
        UsuarioResponse response = usuarioServicio.create(request);
        return ResponseEntity.ok(response);
    }

}
