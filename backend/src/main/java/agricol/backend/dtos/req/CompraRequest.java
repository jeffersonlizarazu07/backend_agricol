package agricol.backend.dtos.req;

import agricol.backend.utiles.PayType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraRequest {
    
    private PayType tipoPago;

    private Integer productoId;

    private Double cantidad;
    
}
