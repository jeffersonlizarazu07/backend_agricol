package agricol.backend.dtos.res;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InformeResponseDTO {
    private int idInforme;
    private double total;
    private double comisionTotal;
    private LocalDate fechaGeneracion;
    private TransaccionResponse transaccion;
}