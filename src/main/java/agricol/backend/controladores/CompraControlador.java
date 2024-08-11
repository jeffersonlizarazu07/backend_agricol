package agricol.backend.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import agricol.backend.dtos.req.CompraRequest;
import agricol.backend.servicios.Inetrfaz.ICompraServicio;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/compra")
@AllArgsConstructor
public class CompraControlador {

    @Autowired
    private final ICompraServicio compraService;

     @GetMapping("/prueba")
    public ResponseEntity<String> inicioSeSion(@RequestParam String compradorId, @RequestBody CompraRequest compraRequest)  {
        compraService.abrirTransaccion(compradorId, compraRequest);
        return ResponseEntity.ok("Hola");
    }
    
}
