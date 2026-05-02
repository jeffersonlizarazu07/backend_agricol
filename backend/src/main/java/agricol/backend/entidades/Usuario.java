package agricol.backend.entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
//Crear clases
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
     @Id
     @Column(nullable = false)
     private String idusuario;

     @Column(nullable = false, length = 35)
     private String nombre;
     @Column(nullable = false, length = 35)
     private String apellido;
     @Column(nullable = false, length = 100)
     private String direccion;
     @Column(nullable = false, length = 100, unique = true)
     private String email;
     
     @Column(nullable = false)
     private String contrasena;

     @ManyToOne
     @JoinColumn(name = "rol_id", referencedColumnName = "idrol")
     private Rol rol;

     @ToString.Exclude
     @EqualsAndHashCode.Exclude
     @OneToMany(mappedBy = "vendedor", cascade = CascadeType.REMOVE, orphanRemoval = true)
     private List<Producto> productos;

}
