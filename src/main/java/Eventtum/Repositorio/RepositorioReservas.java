
package Eventtum.Repositorio;


import Eventtum.Modelo.DetallePedido;
import Eventtum.Modelo.Locaciones;
import Eventtum.Modelo.Pedidos;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservas {
    
    @Autowired
    private InterfaceReservas PedidosCRUD;
    
    public Optional<Pedidos> BuscarReserva(Integer id){
        return PedidosCRUD.findById(id);
    }
    
    public List<Pedidos> MostrarPedidos(){
        return (List<Pedidos>) PedidosCRUD.findAll();
    }
 
    
    public List<Pedidos> BuscarPorFechaReserva(Date fechareserva){
        return PedidosCRUD.findByFechareserva(fechareserva);
    }
   
    public List<Pedidos> BuscarPorFechaPedido(Date fechapedido){
        return PedidosCRUD.findByFechapedido(fechapedido);
    }
    
    public List<Pedidos> BuscarPorEstado(String estado){
        return PedidosCRUD.findByEstado(estado);
    }
    
    public Pedidos GuardarReserva(Pedidos P){
        return PedidosCRUD.save(P);
    }
    
    
    @Autowired
    private InterfaceDetalleReservas DetallePedidosCRUD;
    
    public List<DetallePedido> BuscarPorPedido(Pedidos P){
        return DetallePedidosCRUD.findByPedido(P);
    }
    
    public List<DetallePedido> BuscarPorLocacion(Locaciones L){
        return DetallePedidosCRUD.findByLocacion(L);
    }
    
    public DetallePedido GuardarDetalles(DetallePedido DP){
        return DetallePedidosCRUD.save(DP);
    }
}