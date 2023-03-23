package Eventtum.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;


@Entity
@Table(name="tbllocaciones")
@Data
public class Locaciones implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idlocacion")
    private Integer idlocacion;
    
    @Column(name= "locnombre")
    private String nombrelocacion;
    
    @Column(name= "locdescripcion")
    private String descriplocacion;
     
    @ManyToOne
    @JoinColumn(name="tblcategorias_idcategoria")
    @JsonIgnoreProperties("locaciones")
    private Categorias tblcategorias;
    
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="tbllocaciones")
    @JsonIgnoreProperties("tbllocaciones")
    public List<PQRS> pqrslocacion;
    
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="locacion")
    @JsonIgnoreProperties("locacion")
    public List<DetallePedido> reservaslocacion;
}