package agricol.backend.entidades;

import agricol.backend.utiles.UserRoles;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity (name ="roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rol{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrol;
    
    @Column(nullable = false, unique = true)
    private UserRoles nombreRol;

}

