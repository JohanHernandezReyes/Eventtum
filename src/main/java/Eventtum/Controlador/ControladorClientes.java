package Eventtum.Controlador;

import Eventtum.Modelo.Clientes;
import Eventtum.Servicios.ServiciosClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST})
public class ControladorClientes {
    
    @Autowired
    private ServiciosClientes ClientesServices;
    
    @GetMapping("/{NIT}")
    public boolean BuscarCliente(@PathVariable("NIT") String NIT){
        return ClientesServices.BuscarCliente(NIT);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clientes GuardarCliente(@RequestBody Clientes C){
        return ClientesServices.GuardarCliente(C);
    }
    
}
