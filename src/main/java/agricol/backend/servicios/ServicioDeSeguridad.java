package agricol.backend.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import agricol.backend.dtos.req.InicioSesionReq;
import agricol.backend.utiles.JWTUtil;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ServicioDeSeguridad  {

    @Autowired
    private final AuthenticationManager authenticationManager;

   





   

    public String login(InicioSesionReq request){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getContrasena());
        authenticationManager.authenticate(token);
        String jwt = JWTUtil.generarJTWT(request.getEmail());
        return jwt;
    }


    
}
