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

    @NotBlank(message = "El nombre es obligatorio y unico")
    @Size(max = 50)
    private String nombre;

    @Getter @Setter @Size(max = 25)
    private int telefono;

    @Size(max = 128)
    private String address;

    @NotBlank @Email(message = "Debe tener formato de correo electronico")
    @Size(max = 100)
    private String email;

    @Getter @Setter
    @Size(max = 35)
    private long code;

    @Getter @Setter
    private int status;

    @Size(max = 256)
    private String comment;
}
