package voluntariado.demo.services;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import voluntariado.demo.models.VolunteerAbility;
import voluntariado.demo.repositories.VolunteerAbilityRepository;

import java.util.List;

@CrossOrigin
@RestController
public class VolunteerAbilityService {
    private final VolunteerAbilityRepository volunteerAbilityRepository;

    public VolunteerAbilityService(VolunteerAbilityRepository volunteerAbilityRepository) { this.volunteerAbilityRepository = volunteerAbilityRepository;}

    @PostMapping("/volunteerAbility")
    public VolunteerAbility createVolunteerAbility(@RequestBody VolunteerAbility volunteerAbility){
        return volunteerAbilityRepository.createVolunteerAbility(volunteerAbility);
    }

    @GetMapping("/volunteerAbility")
    public List<VolunteerAbility> getAllVolunterAbility(){
        return volunteerAbilityRepository.getAllVolunteerAbility();
    }
    
    @GetMapping("/volunteerAbility/{id}")
    public VolunteerAbility getVolunteerAbilityById(@PathVariable("id") Integer id){
        return volunteerAbilityRepository.getVolunteerAbilityById(id);
    }

    @PutMapping("/volunteerAbility/{id}")
    public VolunteerAbility updateVolunteerAbilityById(@PathVariable("id") Integer id,@RequestBody @Validated @NonNull VolunteerAbility volunteerAbility){
        return volunteerAbilityRepository.updateVolunteerAbilityById(id,volunteerAbility);
    }

    @DeleteMapping("/volunteerAbility/{id}")
    public void  deleteVolunteerAbilityById(@PathVariable("id") Integer id){
        volunteerAbilityRepository.deleteVolunteerAbilityById(id);
    }
}
