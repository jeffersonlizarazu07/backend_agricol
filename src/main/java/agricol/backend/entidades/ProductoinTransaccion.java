package agricol.backend.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity (name ="producto_transacciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoinTransaccion{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private double cantidadComprada;
    private double comision;

    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "idproducto")
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name = "transaccion_id", referencedColumnName = "idTransaccion")
    private Transaccion transaccion;
    
}

