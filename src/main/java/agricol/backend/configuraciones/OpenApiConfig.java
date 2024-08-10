package agricol.backend.configuraciones;


import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
// import springfox.documentation.builders.PathSelectors;
// import springfox.documentation.builders.RequestHandlerSelectors;
// import springfox.documentation.spi.DocumentationType;
// import springfox.documentation.spring.web.plugins.Docket;


/**
 * Configuracion de swagger
 */
@Configuration
@OpenAPIDefinition(info = @Info(title = "Sena Virtual Proyecto", version = "0.1", description = "Api Rest Usando Springboot"))
public class OpenApiConfig {

    // @Bean
    // public Docket api() {
    //     return new Docket(DocumentationType.SWAGGER_2)
    //             .select()
    //             .apis(RequestHandlerSelectors.basePackage("agricol.backend.controladores")) // Cambia esto a tu paquete de controladores
    //             .paths(PathSelectors.any())
    //             .build();
    // }

    

}
