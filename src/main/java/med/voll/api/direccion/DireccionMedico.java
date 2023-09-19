package med.voll.api.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DireccionMedico {
    private String calle;
    private String distrito;
    private String ciudad;
    private String numero;
    private String complemento;

    public DireccionMedico(DatosDireccion direccionM) {
        this.calle = direccionM.calle();
        this.distrito = direccionM.distrito();
        this.ciudad = direccionM.ciudad();
        this.numero = direccionM.numero();  // String.valueOf()  si es numero
        this.complemento = direccionM.complemento();
    }

    public DireccionMedico actualizarDatos(DatosDireccion direccionM) {
        this.calle = direccionM.calle();
        this.distrito = direccionM.distrito();
        this.ciudad = direccionM.ciudad();
        this.numero = direccionM.numero();  // String.valueOf()  si es numero
        this.complemento = direccionM.complemento();
        return this;
    }
}
