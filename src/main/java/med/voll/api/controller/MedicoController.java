package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DatosListadoMedico;
import med.voll.api.medico.DatosRegistroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
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

    @GetMapping
    //public List<DatosListadoMedico> listadoMedicos(){
    //    return medicoRepository.findAll().stream().map(DatosListadoMedico::new).toList();
    //}
    public Page<DatosListadoMedico> listadoMedicos(@PageableDefault(size=2) Pageable paginacion){
        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
    }
}
