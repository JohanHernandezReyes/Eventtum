package Eventtum.Controlador;

import Eventtum.Modelo.Clientes;
import Eventtum.Modelo.Usuarios;
import Eventtum.Servicios.ServiciosClientes;
import java.util.Optional;
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
    
    @GetMapping("/userid/{tblusuarios}")
    public Optional<Clientes> BuscarPorUsuario(@PathVariable("tblusuarios") Usuarios U){
        return ClientesServices.BuscarPorUsuario(U);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clientes GuardarCliente(@RequestBody Clientes C){
        return ClientesServices.GuardarCliente(C);
    }
    
}
