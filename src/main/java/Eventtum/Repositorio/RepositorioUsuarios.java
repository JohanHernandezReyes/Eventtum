
package Eventtum.Repositorio;


import Eventtum.Modelo.Usuarios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUsuarios {
    
    @Autowired
    private InterfaceUsuarios UsersCRUD;
    
    public List<Usuarios> MostrarUsuarios(){
        return (List<Usuarios>) UsersCRUD.findAll();
    }
    
    public Optional<Usuarios> BuscarUsuario(String email){
        return UsersCRUD.findByEmail(email);
    }
    
    public Optional<Usuarios> BuscarUsuarioKey(String password){
        return UsersCRUD.findByPassword(password);
    }
    
    public Usuarios GuardarUsuario(Usuarios U){
        return UsersCRUD.save(U);
    }
}