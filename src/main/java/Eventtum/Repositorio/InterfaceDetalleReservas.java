
package Eventtum.Repositorio;

import Eventtum.Modelo.DetallePedido;
import Eventtum.Modelo.Locaciones;
import Eventtum.Modelo.Pedidos;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceDetalleReservas extends CrudRepository<DetallePedido, Integer>{
    
    public List <DetallePedido> findByPedido(Pedidos pedido);
    public List <DetallePedido> findByLocacion(Locaciones locacion);
    
        
}