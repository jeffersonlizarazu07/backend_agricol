package agricol.backend.dtos.req;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoInTransaccionRequest {
    
    @Positive(message = "La cantidad comprada debe ser un valor positivo")
    private double cantidadComprada;
    
    @Positive(message = "La comisión debe ser un valor positivo")
    private double comision;
    
    @Positive(message = "El ID del producto debe ser un valor positivo")
    private int productoId;

}