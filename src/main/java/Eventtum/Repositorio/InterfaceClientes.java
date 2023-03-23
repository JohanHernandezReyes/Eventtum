
package Eventtum.Repositorio;

import Eventtum.Modelo.Clientes;
import Eventtum.Modelo.Usuarios;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceClientes extends CrudRepository<Clientes, Integer>{
    
    public Optional <Clientes> findByNIT(String ID);
    public Optional <Clientes> findBytblusuarios(Usuarios U);
    
}
