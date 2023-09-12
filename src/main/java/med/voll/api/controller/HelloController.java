package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")  //localhsot:8080/hello
public class HelloController {
    @GetMapping
    public String helloWorld(){
        return "Hello World by Rene Avila Alonso";
    }
}
