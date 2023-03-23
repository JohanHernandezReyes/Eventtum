
package Eventtum.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;


@Entity
@Table(name="tblpqrs")
@Data
public class PQRS implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idpqrs")
    private Integer idpqrs;
    
    @Column(name= "pqrfecha")
    private Date fechapqr;
    
    @Column(name= "pqrtipo")
    private String tipo;
    
    @Column(name= "pqrdetalle")
    private String mensaje;
        
    @ManyToOne
    @JoinColumn(name="tblcliente_idcliente")
    @JsonIgnoreProperties("pqrscliente")
    private Clientes tblclientes;
      
    @ManyToOne
    @JoinColumn(name="tbllocaciones_idlocacion")
    @JsonIgnoreProperties("pqrslocacion")
    private Locaciones tbllocaciones;
    
    @Column(name= "pqrsNombre")
    private String pqrsNombre;
    
    @Column(name= "pqrsEmail")
    private String pqrsEmail;
 
}