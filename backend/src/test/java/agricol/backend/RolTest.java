package agricol.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import agricol.backend.entidades.Rol;
import agricol.backend.utiles.UserRoles;
import org.junit.jupiter.api.Test;

public class RolTest {

    @Test
    public void testCrearRol() {
        // Given (Preparación de datos)
        int idEsperado = 1;
        UserRoles nombreEsperado = UserRoles.ADMIN;

        // When (Creamos la instancia de Rol)
        Rol rol = new Rol(idEsperado, nombreEsperado);

        // Then (Verificamos que los atributos sean correctos)
        assertNotNull(rol);  // Validamos que el objeto no sea null
        assertEquals(idEsperado, rol.getIdrol());  // Verificamos el ID
        assertEquals(nombreEsperado, rol.getNombreRol());  // Verificamos el nombre del rol
    }
}

