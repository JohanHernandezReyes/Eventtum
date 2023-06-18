
package Eventtum.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name="tblpedidos_has_tbllocaciones")
@Data
public class DetallePedido implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "iddetallepedido")
    private Integer iddetallepedido;
    
    @Column(name= "cantidad_personas")
    private Integer numpersonas;
    
    @Column(name= "valor_pedido")
    private Double valor_pedido;
    
    @Column(name= "valor_pagado")
    private Double valor_pagado;
    
    @Column(name= "hora_reserva")
    private String hora_reserva;
    
    
    @ManyToOne
    @JoinColumn(name="idtblpedidos")
    @JsonIgnoreProperties("reservaspedido")
    private Pedidos pedido;
    
    @ManyToOne
    @JoinColumn(name="idtbllocaciones")
    @JsonIgnoreProperties("reservaslocacion")
    private Locaciones locacion;
}