package agricol.backend.dtos.res;

import agricol.backend.entidades.UnidComercializacion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoResponseBasic {
    private int idproducto;
    private String nombreProducto;
    private String clasificacion;
    private String localizacion;
    private String descripcion;
    private double precio;
    private UnidComercializacion unid;
    private String imagenUrl;
}
