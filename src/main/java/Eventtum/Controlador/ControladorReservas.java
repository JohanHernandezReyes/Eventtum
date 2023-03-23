package Eventtum.Controlador;

import Eventtum.Modelo.DetallePedido;
import Eventtum.Modelo.Locaciones;
import Eventtum.Modelo.Pedidos;
import Eventtum.Servicios.ServiciosReservas;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserva")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST})
public class ControladorReservas {
    
    @Autowired
    private ServiciosReservas ReservaServices;
       
    @GetMapping("/valid/{id}")
    public boolean ValidarReserva(@PathVariable("id") Integer id){
        return ReservaServices.ValidarPedido(id);
    }
    
    @GetMapping("/all")
    public List<Pedidos> MostrarPedidos(){
        return ReservaServices.MostrarPedidos();
    }
    
    
    @GetMapping("/{id}")
    public Optional<Pedidos> BuscarReserva(@PathVariable("id") Integer id){
        return ReservaServices.BuscarReserva(id);
    }

    @GetMapping("/{fechapedido}")
    public List<Pedidos> BuscarPorFechaPedido(@PathVariable("fechapedido") Date fechapedido){
        return ReservaServices.BuscarPorFechaPedido(fechapedido);
    }
   
    @GetMapping("/{fechareserva}")
    public List<Pedidos> BuscarPorFechaReserva(@PathVariable("fechareserva") Date fechareserva){
        return ReservaServices.BuscarPorFechaReserva(fechareserva);
    }
    
    @GetMapping("/{estado}")
    public List<Pedidos> BuscarPorEstado(@PathVariable("estado") String estado){
        return ReservaServices.BuscarPorEstado(estado);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedidos GuardarReserva(@RequestBody Pedidos P){
        return ReservaServices.GuardarReserva(P);
    }
    
    @PostMapping("details/new")
    @ResponseStatus(HttpStatus.CREATED)
    public DetallePedido GuardarDetallesReserva(@RequestBody DetallePedido DP){
        return ReservaServices.GuardarDetalles(DP);
    }
    
    @GetMapping("details/{idtblpedidos}")
    public List<DetallePedido> BuscarPorPedido(@PathVariable("idtblpedidos") Pedidos P){
        return ReservaServices.BuscarPorPedido(P);
    }
    
    @GetMapping("details/{idtbllocaciones}")
    public List<DetallePedido> BuscarPorLocacion(@PathVariable("idtbllocaciones") Locaciones L){
        return ReservaServices.BuscarPorLocacion(L);
    }
}
