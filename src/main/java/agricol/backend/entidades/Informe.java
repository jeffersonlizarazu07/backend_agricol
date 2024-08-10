package agricol.backend.entidades;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity (name ="informes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Informe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInforme;

    private double total;
    private double comisionTotal;
    private LocalDate fechaGeneracion;

    @ManyToOne
    @JoinColumn(name = "transaccion_id", referencedColumnName = "idTransaccion")
    private Transaccion idTransaccion;
}





