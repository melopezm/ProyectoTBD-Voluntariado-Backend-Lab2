package voluntariado.demo.services;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import voluntariado.demo.models.EmergencyAbility;
import voluntariado.demo.repositories.EmergencyAbilityRepository;

import java.util.List;

@CrossOrigin
@RestController
public class EmergencyAbilityService {

    private final EmergencyAbilityRepository eme_habRepo;

    public EmergencyAbilityService( EmergencyAbilityRepository eme_habRepo )
    {
        this.eme_habRepo = eme_habRepo;
    }

    @GetMapping( "/EmergencyAbility/all" )
    public List<EmergencyAbility> getAllEmergencyAbility()
    {
        return eme_habRepo.getAllEmergencyAbility();
    }

    @PostMapping( "/EmergencyAbility/add" )
    @ResponseBody
    public EmergencyAbility createEmergencyAbility( @RequestBody EmergencyAbility emergencyAbility )
    {
        return eme_habRepo.createEmergencyAbility( emergencyAbility );
    }

    @GetMapping( "/EmergencyAbility/{id}" )
    public EmergencyAbility getEmergencyAbilityById( @PathVariable(value = "id") Integer id )
    {
        return eme_habRepo.getEmergencyAbilityById( id );
    }

    @PutMapping( "/EmergencyAbility/update/{id}" )
    @ResponseBody
    public EmergencyAbility updateEmergencyAbilityById( @RequestBody EmergencyAbility emergencyAbility, @PathVariable(value = "id") Integer id )
    {
        return eme_habRepo.updateEmergencyAbilityById( emergencyAbility, id );
    }

    @DeleteMapping( "/EmergencyAbility/delete/{id}" )
    public void deleteEmergencyAbility( @PathVariable(value = "id") Integer id )
    {
        eme_habRepo.deleteEmergencyAbility( id );
    }
}