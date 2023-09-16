package med.voll.api.medico;

public record DatosListadoMedico(String nombre, String especialidad, String dni, String email) {
    public DatosListadoMedico(Medico medico){
        this(medico.getNombre(), medico.getEspecialidad().toString(), medico.getDni(), medico.getEmail());
    }
}
