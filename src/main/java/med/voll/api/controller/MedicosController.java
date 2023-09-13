package med.voll.api.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import med.voll.api.medico.DatosRegistroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicosController {
    @PostMapping
    public void registraMedico(@RequestBody DatosRegistroMedico datosRegistroMedico){
        // se escribe Syso Cntrl+space
        System.out.println("El request llega correctamente");
        // VALIDA DATOS QUE LLEGAN
        System.out.println(datosRegistroMedico);
        //System.out.println(datosRegistroMedico.nombre);
        //System.out.println("");
    }
}
