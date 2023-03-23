package Eventtum.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;


@Entity
@Table(name="tblcategorias")
@Data
public class Categorias implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idcategoria")
    private Integer idcategoria;
    
    @Column(name= "catnombre")
    private String categnombre;
    
    
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="tblcategorias")
    @JsonIgnoreProperties("tblcategorias")
    public List<Locaciones> locaciones;
}