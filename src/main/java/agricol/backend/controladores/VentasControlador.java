package agricol.backend.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import agricol.backend.dtos.req.CompraRequest;
import agricol.backend.dtos.res.CompraResponse;
import agricol.backend.dtos.res.TransaccionResponse;
import agricol.backend.servicios.Inetrfaz.ICompraServicio;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/ventas")
@AllArgsConstructor
public class VentasControlador {

    @Autowired
    private final ICompraServicio compraService;


    @GetMapping("/misVentas/{vendedorId}")
    public ResponseEntity<List<TransaccionResponse>> getMethodName(@PathVariable String vendedorId) {
        return ResponseEntity.ok(compraService.misVentas(vendedorId));
    }
    
}