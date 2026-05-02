package agricol.backend.configuraciones;


import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;



/**
 * Configuracion de swagger
 */
@Configuration
@OpenAPIDefinition(info = @Info(title = "Sena Virtual Proyecto", version = "0.1", description = "Api Rest Usando Springboot"))
public class OpenApiConfig {

}
