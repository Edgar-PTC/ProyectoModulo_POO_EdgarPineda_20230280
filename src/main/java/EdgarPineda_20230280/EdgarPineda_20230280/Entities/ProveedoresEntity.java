package EdgarPineda_20230280.EdgarPineda_20230280.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
//Tabla a la que pertenece
@Table(name = "TBPROVIDER")
@Getter @Setter @ToString @EqualsAndHashCode
public class ProveedoresEntity {

    //Atributos = Columnas
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_provider")
    @SequenceGenerator(name = "seq_provider", sequenceName = "seq_provider", allocationSize = 1)
    @Column(name = "PROVIDERID")
    private long id;

    @Column(name = "PROVIDERNAME", unique = true)
    private String nombre;

    @Column(name = "PROVIDERPHONE")
    private int telefono;

    @Column(name = "PROVIDERADDRESS")
    private String address;

    @Column(name = "PROVIDEREMAIL")
    private String email;

    @Column(name = "PROVIDERCODE", unique = true)
    private long code;

    @Column(name = "PROVIDERSTATUS")
    private int status;

    @Column(name = "PROVIDERCOMMENTS")
    private String comment;
}
