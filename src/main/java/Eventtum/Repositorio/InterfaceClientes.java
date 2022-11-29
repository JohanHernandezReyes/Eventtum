
package Eventtum.Repositorio;

import Eventtum.Modelo.Clientes;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceClientes extends CrudRepository<Clientes, Integer>{
    
    public Optional <Clientes> findByNIT(String ID);
}
