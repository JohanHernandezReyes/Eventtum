
package Eventtum.Repositorio;

import Eventtum.Modelo.Locaciones;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioLocaciones {

    @Autowired
    private InterfaceLocaciones LocacionesCRUD;
      
    public Optional<Locaciones> BuscarLocacion(String nombrelocacion){
        return LocacionesCRUD.findBynombrelocacion(nombrelocacion);
    }
    
    public List <Locaciones> MostrarLocaciones(){
        return (List <Locaciones>) LocacionesCRUD.findAll();
    }
    
    public Locaciones GuardarLocacion(Locaciones L){
        return LocacionesCRUD.save(L);
    }
}
