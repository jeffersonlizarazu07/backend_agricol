package agricol.backend.utiles;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JWTUtil {
    

    public static final String SECRET_KEY = "agricol";

    public static String generarJTWT(String email){
        return JWT.create()
                .withSubject(email)
                .withIssuer("AgricolV1")
                .withClaim("Prueba", "modificando")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(15)))
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }
}
