package agricol.backend.dtos.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoRequest {
    
    private int idproducto;

    @NotBlank(message = "El nombre del producto no puede estar vacío")
    @Size(max = 100, message = "El nombre del producto no puede tener más de 100 caracteres")
    private String nombrePoducto;

    @NotBlank(message = "La clasificación no puede estar vacía")
    @Size(max = 50, message = "La clasificación no puede tener más de 50 caracteres")
    private String clasificacion;

    @PositiveOrZero(message = "La cantidad disponible debe ser un valor positivo o cero")
    private double cantidaDisponible;

    @NotBlank(message = "La localización no puede estar vacía")
    @Size(max = 100, message = "La localización no puede tener más de 100 caracteres")
    private String localizacion;

    @Positive(message = "El precio debe ser un valor positivo")
    private double precio;

    @Positive(message = "El ID del vendedor debe ser un valor positivo")
    private String vendedorid;

    @Positive(message = "El ID de la unidad de comercialización debe ser un valor positivo")
    private int unidComercializacionid;

    @NotBlank(message = "La imagen URL no puede estar vacía")
    @Size(max = 200, message = "La imagen URL no puede tener más de 200 caracteres")
    private String imagenUrl;
}