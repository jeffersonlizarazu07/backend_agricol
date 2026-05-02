package agricol.backend.servicios;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agricol.backend.dtos.req.ProductoRequest;
import agricol.backend.dtos.res.ProductoResponse;
import agricol.backend.dtos.res.UsuarioResponse;
import agricol.backend.entidades.Producto;
import agricol.backend.entidades.Usuario;
import agricol.backend.exepciones.IdNotFoundException;
import agricol.backend.repositorios.ProductoRepositorio;
import agricol.backend.repositorios.UsuarioRepositorio;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ProductoService implements ServicioAbstracto<ProductoRequest, ProductoResponse, Integer> {

    @Autowired
    private final ProductoRepositorio productoRepositorio;

    @Autowired
    private final UsuarioRepositorio usuariorepositorio;

    @Override
    public Page<ProductoResponse> getAll(int page, int size) {
        PageRequest pagination = PageRequest.of(page, size);
        Page<Producto> productos = productoRepositorio.findAll(pagination);
        return productos.map(this::convertProductoToResponse);
    }

    @Override
    public ProductoResponse create(ProductoRequest request) {
        Usuario usuarioVenderdor = usuariorepositorio.findById(request.getVendedorid()).orElseThrow(()-> new IdNotFoundException("Usuario"));
        Producto producto = convertProductoRequestToEntity(request, usuarioVenderdor);
        Producto productoCreado = productoRepositorio.save(producto);
        return convertProductoToResponse(productoCreado);
    }

    @Override
    public ProductoResponse update(ProductoRequest request, Integer id) {
        Usuario usuarioVenderdor = usuariorepositorio.findById(request.getVendedorid()).orElseThrow(()-> new IdNotFoundException("Usuario"));
        Producto producto = convertProductoRequestToEntity(request, usuarioVenderdor);
        Producto productoCreado = productoRepositorio.save(producto);
        return convertProductoToResponse(productoCreado);
    }

    @Override
    public void delete(Integer id) {
      
    }

    @Override
    public ProductoResponse getById(Integer id) {
        Producto producto = productoRepositorio.findById(id).orElseThrow(()-> new IdNotFoundException("Producto"));
        return convertProductoToResponse(producto);
    }

    public ProductoResponse convertProductoToResponse(Producto producto) {
        ProductoResponse response = new ProductoResponse();
        BeanUtils.copyProperties(producto, response);
        response.setUnid(producto.getUnidComercializacion());
        response.setVendedor(convertUsuarioToResponse(producto.getVendedor()));
        return response;        
    }

     private UsuarioResponse convertUsuarioToResponse(Usuario usuario) {
        UsuarioResponse response = new UsuarioResponse();
        BeanUtils.copyProperties(usuario, response);
        response.setRol(usuario.getRol());
        return response;
    }

    private Producto convertProductoRequestToEntity(ProductoRequest request, Usuario usuario) {
        Producto producto = new Producto();
        BeanUtils.copyProperties(request, producto);
        producto.setVendedor(usuario);
        return producto;
    }
}
