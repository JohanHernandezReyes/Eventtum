package Eventtum.Servicios;

import Eventtum.Modelo.Clientes;
import Eventtum.Repositorio.RepositorioClientes;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosClientes {
    
    @Autowired
    private RepositorioClientes ClientesRepositorio;
    
    public boolean BuscarCliente(String NIT){
        Optional<Clientes> ClienteX=ClientesRepositorio.BuscarCliente(NIT);
         if(ClienteX.isPresent()){
            return true;
        }
        return false;  
    }
    
    
    public Clientes GuardarCliente(Clientes C){
        if (C.getIdCliente()==null){
            return ClientesRepositorio.GuardarCliente(C);
        }else{
            Optional<Clientes> ClienteX=ClientesRepositorio.BuscarCliente(C.getNIT());
            if(!ClienteX.isPresent()){
                return ClientesRepositorio.GuardarCliente(C);
            } else {
                return C;
            }     
        }
    }
      
}
