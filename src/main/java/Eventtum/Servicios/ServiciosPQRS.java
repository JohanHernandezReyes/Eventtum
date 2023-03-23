
package Eventtum.Servicios;

import Eventtum.Modelo.PQRS;
import Eventtum.Repositorio.RepositorioPQRS;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosPQRS {
   
    @Autowired
    private RepositorioPQRS PQRSRepositorio;
    
    public PQRS GuardarPQRS(PQRS P) {
        return PQRSRepositorio.GuardarPQRS(P);        
    }
      
}
