package agricol.backend.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agricol.backend.dtos.req.ProductoRequest;
import agricol.backend.dtos.res.ProductoResponse;
import agricol.backend.servicios.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoControlador {

    @Autowired
    private final ProductoService productoServicio;

    @GetMapping()
    public ResponseEntity<Page<ProductoResponse>> getMethodName(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        return  ResponseEntity.ok(productoServicio.getAll(page-1, size));
    }
    
    @PostMapping("/create")
    public ResponseEntity<ProductoResponse> postMethodName(@RequestBody @Validated ProductoRequest request) {
        return ResponseEntity.ok(productoServicio.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponse> putMethodName(@PathVariable int id, @RequestBody @Validated ProductoRequest request){
        ProductoResponse response = productoServicio.update(request, id);
        return ResponseEntity.ok(response);
    }

    
    
    
}
