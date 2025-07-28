package EdgarPineda_20230280.EdgarPineda_20230280.Models.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString @EqualsAndHashCode
@Getter @Setter
public class ProveedoresDTO {
    private long id;

    //Etiquetas para que no este vacio y que su valor no se pase de 50 como esta establecido en la base
    @NotBlank(message = "El nombre es obligatorio y unico")
    @Size(max = 50)
    private String nombre;

    //Etiquetas para que su valor no se pase de 25 como esta establecido en la base
    @Getter @Setter @Size(max = 25)
    private String telefono;

    //Etiquetas para que su valor no se pase de 128 como esta establecido en la base
    @Size(max = 128)
    private String address;

    //Etiquetas para que su valor no se pase de 100 como esta establecido en la base y sea formato email
    @Email(message = "Debe tener formato de correo electronico")
    @Size(max = 100)
    private String email;

    //Etiquetas para que su valor no se pase de 35 como esta establecido en la base
    @Getter @Setter
    @Size(max = 35)
    private String code;

    @Getter @Setter
    private Boolean status;

    //Etiquetas para que su valor no se pase de 256 como esta establecido en la base
    @Size(max = 256)
    private String comment;
}
