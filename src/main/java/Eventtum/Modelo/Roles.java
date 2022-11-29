package Eventtum.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;


@Entity
@Table(name="tblroles")
@Data
public class Roles implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idrol")
    private Integer idrol;
    
    @Column(name= "roltipo")
    private String roltipo;
    
    @Column(name= "roldescripcion")
    private String roldescripcion;
    
    @Column(name= "rolestado")
    private String rolestado;
  
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="tblroles")
    @JsonIgnoreProperties("tblroles")
    public List<Usuarios> users;
}