
package Eventtum.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;


@Entity
@Table(name="tblclientes")
@Data
public class Clientes implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idcliente")
    private Integer idCliente;
    
    @Column(name= "cli_identificacion")
    private String NIT;
    
    @Column(name= "clinombre_razonsocial")
    private String name;
    
    @Column(name= "clitelefono")
    private String tel;
  
    @Column(name="clidireccion")
    private String direccion;
    
    @Column(name="clifecharegistro")
    private Date fechareg;
    
    @ManyToOne
    @JoinColumn(name="tblciudad_idciudad")
    @JsonIgnoreProperties("clientesciu")
    private Ciudades tblciudad;
    
    @OneToOne
    @JsonIgnoreProperties("cliente")
    private Usuarios tblusuarios; 
    
    @ManyToOne
    @JoinColumn(name="tbltipoid_idtipoid")
    @JsonIgnoreProperties("clientestip")
    private Tipoid tbltipoid;
    
 
}