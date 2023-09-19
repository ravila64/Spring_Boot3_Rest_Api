package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DatosListadoMedico;
import med.voll.api.paciente.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;
    @PostMapping
    @Transactional
    public void registraPaciente(@RequestBody @Valid DatosRegistroPaciente datosRegistroPaciente) {
        pacienteRepository.save(new Paciente(datosRegistroPaciente));
        System.out.println("El request llega correctamente Paciente");
        System.out.println(datosRegistroPaciente);
    }
    @GetMapping
    public Page<DatosListaPaciente> listaPacientes(@PageableDefault(size=2) Pageable paginacion){
        //    return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
        // se coloca findByCampoValor dependiendo de la buscqueda
        return pacienteRepository.findByActivoTrue(paginacion).map(DatosListaPaciente::new);
    }
   /* @GetMapping
    public Page<DatosListaPaciente> listaPacientes(@PageableDefault(page = 1, size = 10, sort = {"nombre"}) Pageable paginacion){
        // return medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedico::new);
        return null;
    }*/
    @PutMapping
    @Transactional
    public void atualizarPaciente(@RequestBody @Valid DatosActualizarPaciente datos) {
        var paciente = pacienteRepository.getReferenceById(datos.id());
        paciente.actualizarDatos(datos);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarPaciente(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.desactivarPaciente();
    }

}