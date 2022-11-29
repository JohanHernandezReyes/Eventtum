
package Eventtum.Repositorio;

import Eventtum.Modelo.Clientes;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClientes {

    @Autowired
    private InterfaceClientes ClientesCRUD;
      
    public Optional<Clientes> BuscarCliente(String id){
        return ClientesCRUD.findByNIT(id);
    }
    public Clientes GuardarCliente(Clientes C){
        return ClientesCRUD.save(C);
    }
}
