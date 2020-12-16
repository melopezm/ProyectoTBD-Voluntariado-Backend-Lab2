package voluntariado.demo.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Principal {
    @GetMapping("/")
    public String HelloWorld(){
        return "Hello World";
    }
}
