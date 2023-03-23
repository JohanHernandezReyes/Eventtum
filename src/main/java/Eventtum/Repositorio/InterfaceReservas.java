
package Eventtum.Repositorio;

import Eventtum.Modelo.Pedidos;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceReservas extends CrudRepository<Pedidos, Integer>{
    
    public List <Pedidos> findByFechapedido(Date fechapedido);
    public List <Pedidos> findByFechareserva(Date fechareserva);
    public List <Pedidos> findByEstado(String estado);
        
}

