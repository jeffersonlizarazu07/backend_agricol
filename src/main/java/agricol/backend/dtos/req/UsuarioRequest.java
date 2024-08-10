
package agricol.backend.dtos.req;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {
    private String idusuario;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 35, message = "El nombre no puede tener más de 35 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(max = 35, message = "El apellido no puede tener más de 35 caracteres")
    private String apellido;

    @NotBlank(message = "La dirección no puede estar vacía")
    @Size(max = 100, message = "La dirección no puede tener más de 100 caracteres")
    private String direccion;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El email debe ser válido")
    @Size(max = 100, message = "El email no puede tener más de 100 caracteres")
    private String email;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 35, message = "El nombre de usuario no puede tener más de 35 caracteres")
    private String usuario;
    
    
    @NotBlank(message = "La contraseña no puede estar vacía")
    private String contrasena;

    @NotNull(message = "El ID del rol no puede estar vacío")
    private int rolId;

}