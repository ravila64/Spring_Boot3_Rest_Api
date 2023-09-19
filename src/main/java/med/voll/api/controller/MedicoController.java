package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;
    @PostMapping
    public void registraMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico){
        medicoRepository.save(new Medico(datosRegistroMedico));
        // se escribe Syso Cntrl+space
        System.out.println("El request llega correctamente");
        // VALIDA DATOS QUE LLEGAN
        System.out.println(datosRegistroMedico);
        //System.out.println(datosRegistroMedico.nombre);
        //System.out.println("");
    }

    //@GetMapping
    //public List<DatosListadoMedico> listadoMedicos(){
    //    return medicoRepository.findAll().stream().map(DatosListadoMedico::new).toList();
    //}
    // cuando se llama el repositorio directo, no es necesario @Transactional
    @GetMapping
    public Page<DatosListadoMedico> listadoMedicos(@PageableDefault(size=2) Pageable paginacion){
    //    return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
        // se coloca findByCampoValor dependiendo de la buscqueda
        return medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedico::new);
    }
    @PutMapping
    @Transactional
    public void actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico){
        Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
    }
    // delete logico
    @DeleteMapping("/{id}") // hace mapeo que borrar   ("/3") record con id=3
    @Transactional
    public void eliminarMedico(@PathVariable Long id ){
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
    }
    // Eliminado total del medico en la base de datos
    //public void eliminarMedico(@PathVariable Long id ){
    //    Medico medico = medicoRepository.getReferenceById(id);
    //    medicoRepository.delete(medico);
    //}
}
