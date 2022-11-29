    package Eventtum.Controlador;

import Eventtum.Modelo.Usuarios;
import Eventtum.Servicios.ServiciosUsuarios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST})
public class ControladorUsuarios {
    
    @Autowired
    private ServiciosUsuarios UsersServices;
    
    @GetMapping("/all")
    public List<Usuarios> MostrarUsers(){
        return UsersServices.MostrarUsers();
    }
    
    @GetMapping("/{email}")
    public boolean BuscarUser(@PathVariable("email") String email){
        return UsersServices.BuscarUser(email);
    }
    
    @GetMapping("/{email}/{password}")
    public Optional<Usuarios> BuscarUserKey(@PathVariable("email") String email, @PathVariable("password") String password){
        return UsersServices.BuscarUserKey(email, password);
    }
   
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuarios GuardarUser(@RequestBody Usuarios U){
        return UsersServices.GuardarUser(U);
    }
    
}