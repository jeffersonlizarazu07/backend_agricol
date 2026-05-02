package agricol.backend.entidades;



import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity (name ="tranascciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransaccion;
    
    private String medioDePago;
    private LocalDate fecha;
    private Double total;

    @ManyToOne
    @JoinColumn(name="vendedor_id", referencedColumnName = "idusuario")
    private Usuario usuarioVendedor;

    @ManyToOne
    @JoinColumn(name="comprador_id", referencedColumnName = "idusuario")
    private Usuario usuarioComprador;

    @OneToMany(mappedBy = "transaccion")
    private List<ProductoinTransaccion> listaTransacciones;
    
}


