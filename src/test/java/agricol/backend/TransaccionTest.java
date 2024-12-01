package agricol.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import agricol.backend.entidades.ProductoinTransaccion;
import agricol.backend.entidades.Transaccion;
import agricol.backend.entidades.Usuario;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class TransaccionTest {

    @Test
    public void testCrearTransaccion() {
        // Given (Preparación de datos)
        Usuario vendedor = new Usuario();  // Instancia de prueba (dummy)
        vendedor.setIdusuario(String.valueOf(1));
        vendedor.setNombre("Vendedor Test");

        Usuario comprador = new Usuario();
        comprador.setIdusuario(String.valueOf(2));
        comprador.setNombre("Comprador Test");

        ProductoinTransaccion producto1 = new ProductoinTransaccion();
        ProductoinTransaccion producto2 = new ProductoinTransaccion();
        List<ProductoinTransaccion> productos = List.of(producto1, producto2);

        // When (Ejecutamos la lógica)
        Transaccion transaccion = new Transaccion(
                1, "Tarjeta de crédito", LocalDate.now(), 500.0,
                vendedor, comprador, productos
        );

        // Then (Verificación de resultados)
        assertNotNull(transaccion);
        assertEquals(1, transaccion.getIdTransaccion());
        assertEquals("Tarjeta de crédito", transaccion.getMedioDePago());
        assertEquals(500.0, transaccion.getTotal());
        assertEquals(vendedor, transaccion.getUsuarioVendedor());
        assertEquals(comprador, transaccion.getUsuarioComprador());
        assertEquals(2, transaccion.getListaTransacciones().size());
    }
}
