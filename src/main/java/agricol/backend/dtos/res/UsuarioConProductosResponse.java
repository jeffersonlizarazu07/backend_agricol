package agricol.backend.dtos.res;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioConProductosResponse {
    private int idusuario;
    private String nombre;
    private String apellido;
    private String direccion;
    private String email;
    private int telefono;
    private int rolId;
    private List<ProductoResponse> productos;
}