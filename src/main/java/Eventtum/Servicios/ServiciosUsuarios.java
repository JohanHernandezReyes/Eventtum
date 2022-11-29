package Eventtum.Servicios;

import Eventtum.Modelo.Usuarios;
import Eventtum.Repositorio.RepositorioUsuarios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosUsuarios{
    
    @Autowired
    private RepositorioUsuarios UsersRepository;
    
 
    public List <Usuarios> MostrarUsers(){
        return (List<Usuarios>) UsersRepository.MostrarUsuarios();
    }    
    
 
    public boolean BuscarUser(String email){
        Optional<Usuarios> UserX=UsersRepository.BuscarUsuario(email);
         if(UserX.isPresent()){
            return true;
        }
        return false;  
    }
    
    
    public Optional<Usuarios> BuscarUserKey (String email, String password){
        Optional<Usuarios> UserX=UsersRepository.BuscarUsuario(email);
        Optional<Usuarios> UserY=UsersRepository.BuscarUsuarioKey(password);
        Usuarios UserZ=new Usuarios();
        UserZ.setEmail(email);UserZ.setPassword(password); UserZ.setName("NO DEFINIDO");
        if(UserX.isPresent() && UserX.equals(UserY)){
            return UserX;
        }
        return Optional.of(UserZ);  
    }

    public Usuarios GuardarUser(Usuarios U){
        if (U.getId()==null){
            return UsersRepository.GuardarUsuario(U);
        }else{
            Optional<Usuarios> UserX=UsersRepository.BuscarUsuario(U.getEmail());
            if(!UserX.isPresent()){
                return UsersRepository.GuardarUsuario(U);
            } else {
                return U;
            }     
        }
    }
 
}