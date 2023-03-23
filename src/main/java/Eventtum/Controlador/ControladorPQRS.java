
package Eventtum.Controlador;

import Eventtum.Modelo.PQRS;
import Eventtum.Servicios.ServiciosPQRS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pqrs")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST})
public class ControladorPQRS {
    
    @Autowired
    private ServiciosPQRS PQRSServices;
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public PQRS GuardarPQRS(@RequestBody PQRS P){
        return PQRSServices.GuardarPQRS(P);
    }
}

