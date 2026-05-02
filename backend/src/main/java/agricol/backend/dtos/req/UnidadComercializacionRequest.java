package agricol.backend.dtos.req;

import jakarta.validation.constraints.NotBlank;

public class UnidadComercializacionRequest {
     
    @NotBlank(message = "El nombre de unidad comercializacion hace refenncia a la presentacion del producto, Kg, Paquete, etc...")
    private String nombre;
    
}
