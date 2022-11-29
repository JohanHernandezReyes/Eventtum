
package Eventtum.Repositorio;

import Eventtum.Modelo.Usuarios;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceUsuarios extends CrudRepository<Usuarios, Integer>{
    
    public Optional <Usuarios> findByEmail(String email);
    public Optional <Usuarios> findByPassword(String password);
    
   
    
}
