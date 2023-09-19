package med.voll.api.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DireccionPaciente {
    private String urbanizacion;
    private String distrito;
    private String codigoPostal;
    private String complemento;
    private String numero;
    private String provincia;
    private String ciudad;

    public DireccionPaciente(DatosDireccionPaciente direccionP) {
        this.urbanizacion = direccionP.urbanizacion();
        this.distrito = direccionP.distrito();
        this.codigoPostal = direccionP.codigoPostal();
        this.complemento = direccionP.complemento();
        this.numero = direccionP.numero();
        this.provincia = direccionP.provincia();
        this.ciudad = direccionP.ciudad();
    }

    public DireccionPaciente actualizarDatos(DatosDireccionPaciente direccion) {
        this.urbanizacion = direccion.urbanizacion();
        this.distrito = direccion.distrito();
        this.codigoPostal = direccion.codigoPostal();
        this.complemento = direccion.complemento();
        this.numero = direccion.numero();  // String.valueOf()  si es numero
        this.provincia = direccion.provincia();
        this.ciudad = direccion.ciudad();
        return this;
    }
}
