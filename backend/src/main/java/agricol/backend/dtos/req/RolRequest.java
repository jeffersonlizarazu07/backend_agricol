package agricol.backend.dtos.req;

import agricol.backend.utiles.UserRoles;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolRequest {

    @Pattern(regexp = "COMPRADOR|VENDEDOR|COMPRADORVENDEDOR|ADMIN", message = "nombreRol debe ser uno de los valores: COMPRADOR, VENDEDOR, COMPRADORVENDEDOR, ADMIN")
    private UserRoles nombreRol;
}
