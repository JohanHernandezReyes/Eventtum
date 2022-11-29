
package Eventtum.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
@Table(name="tblusuarios")
@Data
public class Usuarios implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idusuario")
    private Integer id;
    
    @Column(name="usunombre")
    private String name;
        
    @Column(name="usucontrasena", length = 12)
    private String password;
    
    @Column(name="usuemail")
    private String email;
    
    @ManyToOne
    @JoinColumn(name="tblroles_idrol")
    @JsonIgnoreProperties("users")
    private Roles tblroles;

    @OneToOne(cascade = {CascadeType.REMOVE},mappedBy="tblusuarios")
    @JsonIgnoreProperties("tblusuarios")
    @NotFound(action=NotFoundAction.IGNORE)
    public Clientes cliente;
    

}