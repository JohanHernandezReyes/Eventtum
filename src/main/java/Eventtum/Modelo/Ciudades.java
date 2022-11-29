package Eventtum.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;


@Entity
@Table(name="tblciudad")
@Data
public class Ciudades implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idciudad")
    private Integer idciudad;
    
    @Column(name= "ciunombre")
    private String nombreciudad;
    
    @Column(name= "ciupais")
    private String pais;
     
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="tblciudad")
    @JsonIgnoreProperties("tblciudad")
    public List<Clientes> clientesciu;
}