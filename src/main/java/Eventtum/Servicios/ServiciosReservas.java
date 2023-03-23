package Eventtum.Servicios;

import Eventtum.Modelo.Pedidos;
import Eventtum.Modelo.Locaciones;
import Eventtum.Modelo.DetallePedido;
import Eventtum.Repositorio.RepositorioReservas;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosReservas{
    
    @Autowired
    private RepositorioReservas ReservasRepository;
     
    public boolean ValidarPedido(Integer id){
        Optional<Pedidos> PedidoX=ReservasRepository.BuscarReserva(id);
         if(PedidoX.isPresent()){
            return true;
        }
        return false;
    }
    
    public Optional<Pedidos> BuscarReserva(Integer id){
        Optional<Pedidos> PedidoX=ReservasRepository.BuscarReserva(id);
        try{
            return PedidoX;
        }
        catch (Exception e){
             return null;
        }
    }
    
    public List <Pedidos> MostrarPedidos(){
        return (List<Pedidos>) ReservasRepository.MostrarPedidos();
   }
    
    
    public List<Pedidos> BuscarPorFechaPedido(Date fechapedido){  
        return (List<Pedidos>) ReservasRepository.BuscarPorFechaPedido(fechapedido);
    }
    
    public List<Pedidos> BuscarPorFechaReserva(Date fechareserva){  
        return (List<Pedidos>) ReservasRepository.BuscarPorFechaReserva(fechareserva);
    }
    
    public List<Pedidos> BuscarPorEstado(String estado){  
        return (List<Pedidos>) ReservasRepository.BuscarPorEstado(estado);
    }

    public Pedidos GuardarReserva(Pedidos P){
        return ReservasRepository.GuardarReserva(P);
    }
 
    public List<DetallePedido> BuscarPorPedido(Pedidos P){
        return ReservasRepository.BuscarPorPedido(P);
    }
    
    public List<DetallePedido> BuscarPorLocacion(Locaciones L){
        return ReservasRepository.BuscarPorLocacion(L);
    }
    
    public DetallePedido GuardarDetalles(DetallePedido DP){
        return ReservasRepository.GuardarDetalles(DP);
    }
}