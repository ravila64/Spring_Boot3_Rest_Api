package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.DireccionMedico;
@Table(name="medicos")
@Entity(name="Medico")
// Entra Lombok, generar codigo automatico cuando entre
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String dni;
    private boolean activo;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private DireccionMedico direccionMedico;

    public Medico(DatosRegistroMedico datosRegistroMedico) {
        this.activo=true;
        this.nombre = datosRegistroMedico.nombre();
        this.email = datosRegistroMedico.email();
        this.telefono = datosRegistroMedico.telefono();
        this.dni = datosRegistroMedico.dni();
        this.especialidad = datosRegistroMedico.especialidad();
        this.direccionMedico = new DireccionMedico(datosRegistroMedico.direccionMed());
    }

    public void actualizarDatos(DatosActualizarMedico datosActualizarMedico) {
        if(datosActualizarMedico.nombre()!=null){
            this.nombre = datosActualizarMedico.nombre();
        }
        if(datosActualizarMedico.dni()!=null){
            this.dni = datosActualizarMedico.dni();
        }
        if(datosActualizarMedico.direccionM()!=null){
            this.direccionMedico = direccionMedico.actualizarDatos(datosActualizarMedico.direccionM());
        }
    }
    public void desactivarMedico() {
        this.activo = false;
    }
}
