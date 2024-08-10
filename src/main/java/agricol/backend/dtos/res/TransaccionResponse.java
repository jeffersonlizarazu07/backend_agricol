package agricol.backend.dtos.res;

import java.time.LocalDate;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransaccionResponse {
    private int idTransaccion;
    private String medioDePago;
    private LocalDate fecha;
    private UsuarioResponse usuarioVendedorId;
    private UsuarioResponse usuarioCompradorId;
    private List<ProductoInTransaccionResponse> listaProductosTransacciones;
}
