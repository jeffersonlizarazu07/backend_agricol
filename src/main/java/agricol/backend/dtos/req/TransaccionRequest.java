package agricol.backend.dtos.req;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransaccionRequest {
    
    @NotBlank(message = "El medio de pago no puede estar vacío")
    private String medioDePago;
    
    @NotNull(message = "La fecha no puede estar vacía")
    private LocalDate fecha;
    
    @Positive(message = "El ID del vendedor debe ser un valor positivo")
    private String usuarioVendedorId;
    
    @Positive(message = "El ID del comprador debe ser un valor positivo")
    private String usuarioCompradorId;
    
    @Valid
    private List<ProductoInTransaccionRequest> listaTransacciones;
}