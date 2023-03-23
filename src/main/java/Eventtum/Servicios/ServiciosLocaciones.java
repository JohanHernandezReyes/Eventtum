package Eventtum.Servicios;

import Eventtum.Modelo.Locaciones;
import Eventtum.Repositorio.RepositorioLocaciones;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosLocaciones {
    
    @Autowired
    private RepositorioLocaciones LocacionesRepositorio;
    
    public Optional<Locaciones> BuscarLocacion(String nombreloc){
        Optional<Locaciones> LocacionX=LocacionesRepositorio.BuscarLocacion(nombreloc);
        try{
            return LocacionX;
        }
        catch (Exception e){
             return null;
        }
    }
    
    public List <Locaciones> MostrarLocaciones(){
        return (List<Locaciones>) LocacionesRepositorio.MostrarLocaciones();
    }
    
    
    public Locaciones GuardarLocacion(Locaciones L){
        if (L.getNombrelocacion()==null){
            return LocacionesRepositorio.GuardarLocacion(L);
        }else{
            Optional<Locaciones> LocacionX=LocacionesRepositorio.BuscarLocacion(L.getNombrelocacion());
            if(!LocacionX.isPresent()){
                return LocacionesRepositorio.GuardarLocacion(L);
            } else {
                return L;
            }     
        }
    }
      
}
