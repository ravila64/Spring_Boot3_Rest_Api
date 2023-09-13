package med.voll.api.medico;

import med.voll.api.direccion.DatosDireccion;

public record DatosRegistroMedico(String nombre, String email, String dni, Especialidad especialidad, DatosDireccion direccion) {

}
