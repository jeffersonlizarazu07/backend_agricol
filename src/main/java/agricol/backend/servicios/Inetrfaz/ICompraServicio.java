package agricol.backend.servicios.Inetrfaz;

import agricol.backend.dtos.req.CompraRequest;
import agricol.backend.dtos.res.CompraResponse;


public interface ICompraServicio  {

    CompraResponse abrirTransaccion( String idComprador ,CompraRequest request);
    
}
