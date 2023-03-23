
package Eventtum.Repositorio;

import Eventtum.Modelo.PQRS;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface InterfacePQRS extends CrudRepository<PQRS, Integer>{
   
}
