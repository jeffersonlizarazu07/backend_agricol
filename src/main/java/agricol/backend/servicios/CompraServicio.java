package agricol.backend.servicios;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agricol.backend.dtos.req.CompraRequest;
import agricol.backend.entidades.Producto;
import agricol.backend.entidades.ProductoinTransaccion;
import agricol.backend.entidades.Transaccion;
import agricol.backend.entidades.Usuario;
import agricol.backend.exepciones.IdNotFoundException;
import agricol.backend.repositorios.ProductoRepositorio;
import agricol.backend.repositorios.ProductoTransaccionRepositorio;
import agricol.backend.repositorios.TransaccionRepositorio;
import agricol.backend.repositorios.UsuarioRepositorio;
import agricol.backend.servicios.Inetrfaz.ICompraServicio;
import lombok.AllArgsConstructor;

@Transactional
@Service
@AllArgsConstructor
public class CompraServicio implements ICompraServicio{

    @Autowired
    private final TransaccionRepositorio transaccionRepositorio;

    @Autowired
    private final ProductoTransaccionRepositorio compraRepositorio;

    @Autowired
    private final ProductoRepositorio productoRepositorio;
    
    @Autowired
    private final UsuarioRepositorio usuarioRepositorio;
    @Override
    @Transactional
    public Transaccion abrirTransaccion(String idComprador, CompraRequest request) {
        
        Usuario usuarioComprador = usuarioRepositorio.findById(idComprador).orElseThrow(()-> new IdNotFoundException("Comprador"));
        Producto producto = productoRepositorio.findById(request.getProductoId()).orElseThrow(() -> new IdNotFoundException("Producto"));
        Usuario usuarioVendedor = usuarioRepositorio.findById(producto.getVendedor().getIdusuario()).orElseThrow(()-> new IdNotFoundException("Vendedor"));
        Transaccion transaccion = new Transaccion();
        

        transaccion.setUsuarioComprador(usuarioComprador);
        transaccion.setUsuarioVendedor(usuarioVendedor);
        transaccion.setMedioDePago(request.getTipoPago().name());
        transaccion.setFecha(LocalDate.now());

        Transaccion tCreada = transaccionRepositorio.save(transaccion);
        ProductoinTransaccion compra = new ProductoinTransaccion();
        compra.setCantidadComprada(request.getCantidad());
        compra.setComision(producto.getPrecio()* 0.019* request.getCantidad()); 
        compra.setProducto(producto);
        compra.setTransaccion(tCreada);
        
        compra.setTotal(producto.getPrecio()*request.getCantidad());
        compraRepositorio.save(compra);

        tCreada.setTotal(producto.getPrecio()*request.getCantidad());
        transaccionRepositorio.save(tCreada);


        return tCreada;
    }

   
   

    
    
    
}
