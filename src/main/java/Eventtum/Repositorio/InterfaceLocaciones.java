
package Eventtum.Repositorio;

import Eventtum.Modelo.Locaciones;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceLocaciones extends CrudRepository<Locaciones, Integer>{
    
    public Optional <Locaciones> findBynombrelocacion(String nombrelocacion);
}
