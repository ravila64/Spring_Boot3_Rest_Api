package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.DireccionMedico;
import med.voll.api.direccion.DireccionPaciente;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Paciente {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String documentoIdentidad;
    private String telefono;
    private boolean activo;
    @Embedded
    private DireccionPaciente direccionPaciente;

    public Paciente(DatosRegistroPaciente datosRegistroPaciente) {
        this.activo = true;
        this.nombre = datosRegistroPaciente.nombre();
        this.email = datosRegistroPaciente.email();
        this.telefono = datosRegistroPaciente.telefono();
        this.documentoIdentidad = datosRegistroPaciente.documentoIdentidad();
        this.direccionPaciente = new DireccionPaciente(datosRegistroPaciente.direccionPac());
    }

    public void actualizarDatos(DatosActualizarPaciente datosActualizarPaciente) {
        if(datosActualizarPaciente.nombre()!=null){
            this.nombre = datosActualizarPaciente.nombre();
        }
        if(datosActualizarPaciente.email()!=null){
            this.email = datosActualizarPaciente.email();
        }
        if(datosActualizarPaciente.telefono()!=null){
            this.telefono = datosActualizarPaciente.telefono();
        }
    }

    public void desactivarPaciente() {
        this.activo = false;
    }
}