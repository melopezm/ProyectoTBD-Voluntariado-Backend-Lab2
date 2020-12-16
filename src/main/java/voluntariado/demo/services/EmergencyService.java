package voluntariado.demo.services;


import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import voluntariado.demo.models.Emergency;
import voluntariado.demo.repositories.EmergencyRepository;
import java.util.List;


@CrossOrigin
@RestController
public class EmergencyService {
    private final EmergencyRepository emergencyRepository;

    public EmergencyService(EmergencyRepository emergencyRepository) {
        this.emergencyRepository = emergencyRepository;
    }

    @PostMapping("/emergency")
    public Emergency createEmergency(@RequestBody Emergency emergency){
        return emergencyRepository.createEmergency(emergency);
    }

    @GetMapping("/emergency")
    public List<Emergency> getAllEmergency(){
        return emergencyRepository.getAllEmergency();
    }

    @GetMapping("/emergency/{id}")
    public Emergency getEmergencyById(@PathVariable("id") Integer id){
        return emergencyRepository.getEmergencyById(id);
    }

    @PutMapping("/emergency/{id}")
    public Emergency updateEmergencyById(@PathVariable("id") Integer id,@RequestBody @Validated @NonNull Emergency emergency){
        return emergencyRepository.updateEmergencyById(id,emergency);
    }

    @DeleteMapping("/emergency/{id}")
    public void  deleteEmergencyById(@PathVariable("id") Integer id){
        emergencyRepository.deleteEmergencyById(id);
    }
}


