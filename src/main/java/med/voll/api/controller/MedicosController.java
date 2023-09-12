package med.voll.api.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicosController {
    @PostMapping
    public void registraMedico(@RequestBody String parametro){
        // se escribe SySo Cntrl+space
        System.out.println("El request llega correctamente");
        // VALIDA DATOS QUE LLEGAN
        System.out.println(parametro);
        //System.out.println(parametro.nombre);
        //System.out.println("");
    }
}
