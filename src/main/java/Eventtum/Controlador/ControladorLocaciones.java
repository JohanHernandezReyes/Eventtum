package Eventtum.Controlador;

import Eventtum.Modelo.Locaciones;
import Eventtum.Servicios.ServiciosLocaciones;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST})
public class ControladorLocaciones {
    
    @Autowired
    private ServiciosLocaciones LocacionesServices;
    
    @GetMapping("/all")
    public List<Locaciones> MostrarLocaciones(){
        return LocacionesServices.MostrarLocaciones();
    }
    
    @GetMapping("/{nombrelocacion}")
    public Optional<Locaciones> BuscarLocacion(@PathVariable("nombrelocacion") String nombrelocacion){
        return LocacionesServices.BuscarLocacion(nombrelocacion);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Locaciones GuardarLocacion(@RequestBody Locaciones L){
        return LocacionesServices.GuardarLocacion(L);
    }
    
}
