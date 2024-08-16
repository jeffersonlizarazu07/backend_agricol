package agricol.backend;

import agricol.backend.controladores.UsuarioControlador;
import agricol.backend.dtos.req.UsuarioRequest;
import agricol.backend.dtos.res.UsuarioResponse;
import agricol.backend.entidades.Rol;
import agricol.backend.servicios.UsuarioServicio;
import agricol.backend.utiles.UserRoles;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(UsuarioControlador.class)
@AutoConfigureMockMvc(addFilters = false)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioServicio usuarioService;

    private static final Logger logger = LoggerFactory.getLogger(UsuarioControllerTest.class);

    @Test
    public void testGetUsuario() throws Exception {
        // Crear un mock de RolResponse
        Rol vendedorRole = new Rol();
        vendedorRole.setIdrol(1);
        vendedorRole.setNombreRol(UserRoles.COMPRADOR);
        
        // Crear un mock de UsuarioResponse basado en los datos proporcionados
        UsuarioResponse usuarioMock = new UsuarioResponse(11111111, "Romario", "Julio", "Calle 19", "roma@jul.com", vendedorRole);        

        // Crear una página que contiene este usuario
        Page<UsuarioResponse> usuarioPage = new PageImpl<>(
            Collections.singletonList(usuarioMock), PageRequest.of(1, 10), 1);

        // Configurar el mock para devolver esta página cuando se llame a getAll
        given(usuarioService.getAll(anyInt(), anyInt())).willReturn(usuarioPage);

        // Ejecutar la solicitud y verificar la respuesta
        mockMvc.perform(get("/Usuarios")
                .param("page", "1")
                .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    public void testCrearUsuario() throws Exception {

        // Crear un mock de RolResponse para el usuario que se va a crear
        Rol vendedorRole = new Rol();
        vendedorRole.setIdrol(1);
        vendedorRole.setNombreRol(UserRoles.COMPRADOR);

        // Crear el mock de UsuarioRequest que se enviará en la solicitud
        UsuarioRequest usuarioRequest = new UsuarioRequest();
        usuarioRequest.setNombre("Romario");
        usuarioRequest.setApellido("Julio");
        usuarioRequest.setDireccion("Calle 19");
        usuarioRequest.setEmail("roma@jul.com");
        usuarioRequest.setRolId(vendedorRole.getIdrol());
        usuarioRequest.setContrasena("password123");
        usuarioRequest.setIdusuario("11111111");
        usuarioRequest.setUsuario("romajul");

        // Crear el mock de UsuarioResponse que se espera como respuesta
        UsuarioResponse usuarioResponse = new UsuarioResponse(11111111, "Romario", "Julio", "Calle 19", "roma@jul.com", vendedorRole);

        // Configurar el mock del servicio para que devuelva la respuesta simulada cuando se llame al método create
        given(usuarioService.create(any(UsuarioRequest.class))).willReturn(usuarioResponse);

        // Ejecutar la solicitud POST y verificar la respuesta
        mockMvc.perform(post("/Usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"nombre\": \"Romario\", \"apellido\": \"Julio\", \"direccion\": \"Calle 19\", \"email\": \"roma@jul.com\", \"usuario\": \"romajul\", \"rolId\": 1, \"contrasena\": \"password123\" }"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idusuario").value(11111111))
                .andExpect(jsonPath("$.nombre").value("Romario"))
                .andExpect(jsonPath("$.apellido").value("Julio"))
                .andExpect(jsonPath("$.direccion").value("Calle 19"))
                .andExpect(jsonPath("$.email").value("roma@jul.com"))
                .andExpect(jsonPath("$.rol.idrol").value(1))
                .andExpect(jsonPath("$.rol.nombreRol").value("COMPRADOR"))
                .andDo(result -> System.out.println(result.getResponse().getContentAsString()));
                 
}
    @Test
    public void testPuth() throws Exception {
        // Crear un mock de RolResponse para el usuario que se va a actualizar
        Rol vendedorRole = new Rol();
        vendedorRole.setIdrol(1);
        vendedorRole.setNombreRol(UserRoles.COMPRADOR);

        // Crear el mock de UsuarioRequest que se enviará en la solicitud
        UsuarioRequest usuarioRequest = new UsuarioRequest();
        usuarioRequest.setNombre("Romario");
        usuarioRequest.setApellido("Julio");
        usuarioRequest.setDireccion("Calle 19");
        usuarioRequest.setEmail("roma@jul.com");
        usuarioRequest.setRolId(vendedorRole.getIdrol());
        usuarioRequest.setContrasena("password123");
        usuarioRequest.setIdusuario("11111111");
        usuarioRequest.setUsuario("romajul");

        // Crear el mock de UsuarioResponse que se espera como respuesta
        UsuarioResponse usuarioResponse = new UsuarioResponse(11111111, "Romario", "Julio", "Calle 19", "roma@jul.com", vendedorRole);
       
        usuarioRequest.setApellido("julio2");
        usuarioResponse.setApellido("julio2");
        given(usuarioService.update(any(UsuarioRequest.class), any(String.class))).willReturn(usuarioResponse);

        mockMvc.perform(put("/Usuarios/{id}", 11111111)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"nombre\": \"Romario\", \"apellido\": \"julio2\", \"direccion\": \"Calle 19\", \"email\": \"roma@jul.com\", \"usuario\": \"romajul\", \"rolId\": 1, \"contrasena\": \"password123\" }"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idusuario").value(11111111))
                .andExpect(jsonPath("$.nombre").value("Romario"))
                .andExpect(jsonPath("$.apellido").value("julio2"))
                .andExpect(jsonPath("$.direccion").value("Calle 19"))
                .andExpect(jsonPath("$.email").value("roma@jul.com"))
                .andExpect(jsonPath("$.rol.idrol").value(1))
                .andExpect(jsonPath("$.rol.nombreRol").value("COMPRADOR"))
                .andDo(result -> System.out.println(result.getResponse().getContentAsString()+ " " +"Zobeida"));
                
        
        logger.info("El usuario con ID 11111111 ha sido actualizado correctamente.");
        System.out.println("El usuario con ID 11111111 ha sido actualizado correctamente.");
    
    }

}
