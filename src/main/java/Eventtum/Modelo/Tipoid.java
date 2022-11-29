package Eventtum.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;


@Entity
@Table(name="tbltipoid")
@Data
public class Tipoid implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idtipoid")
    private Integer idtipoid;
    
    @Column(name= "tipdescripcion")
    private String descripciontipo;
         
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="tbltipoid")
    @JsonIgnoreProperties("tbltipoid")
    public List<Clientes> clientestip;
}