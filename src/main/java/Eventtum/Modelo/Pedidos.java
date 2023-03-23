
package Eventtum.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;


@Entity
@Table(name="tblpedidos")
@Data
public class Pedidos implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idpedido")
    private Integer idpedido;
    
    @Column(name= "pedfechapedido")
    private Date fechapedido;
    
    @Column(name= "pedfechaservicio")
    private Date fechareserva;
    
    @Column(name= "pedestadopedido")
    private String estado;
    
    @Column(name= "pedcomentarios")
    private String comentarios;
    
    @ManyToOne
    @JoinColumn(name="tblcliente_idcliente")
    @JsonIgnoreProperties("reservascliente")
    private Clientes tblclientes;
    
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="pedido")
    @JsonIgnoreProperties("pedido")
    public List<DetallePedido> reservaspedido;
               
}

