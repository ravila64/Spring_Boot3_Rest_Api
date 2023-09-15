package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.direccion.DatosDireccion;

public record DatosRegistroMedico(
        @NotBlank
            String nombre,
        @NotBlank
        @Email
            String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,15}")   // expresion regular de 4 a 6 numeros=digitos
            String dni,
        @NotNull
            Especialidad especialidad,
        @NotNull   // notnull porque direccion es objeto
        @Valid
            DatosDireccion direccion) {
}
