package voluntariado.demo.services;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import voluntariado.demo.models.LogEmergency;
import voluntariado.demo.repositories.LogEmergencyRepository;

import java.util.List;

@CrossOrigin
@RestController
public class LogEmergencyService {
    private final LogEmergencyRepository logEmergencyRepository;

    public LogEmergencyService(LogEmergencyRepository logEmergencyRepository) {
        this.logEmergencyRepository = logEmergencyRepository;
    }
    @GetMapping("/logEmergencies")
    public List<LogEmergency> getAllLogEmergency(){return logEmergencyRepository.getAllLogEmergency();}

    @GetMapping("/logEmergencies/{id}")
    public LogEmergency getLogEmergency(@PathVariable(value = "id") Integer id){return logEmergencyRepository.getLogEmergencyById(id);}
}
