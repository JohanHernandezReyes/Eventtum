
package Eventtum.Repositorio;

import Eventtum.Modelo.PQRS;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPQRS {

    @Autowired
    private InterfacePQRS PQRSCRUD;
      
 
    public PQRS GuardarPQRS(PQRS P){
        return PQRSCRUD.save(P);
    }
}
