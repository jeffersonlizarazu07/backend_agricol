package agricol.backend.servicios.Inetrfaz;

import agricol.backend.dtos.req.CompraRequest;
import agricol.backend.entidades.Transaccion;

public interface ICompraServicio  {

    Transaccion abrirTransaccion( String idComprador ,CompraRequest request);
    
}
