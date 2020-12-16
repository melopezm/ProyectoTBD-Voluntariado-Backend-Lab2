package voluntariado.demo.services;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import voluntariado.demo.models.Volunteer;
import voluntariado.demo.repositories.VolunteerRepository;
import java.util.List;

@CrossOrigin
@RestController
public class VolunteerService {
    private final VolunteerRepository volunteerRepository;

    public VolunteerService(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    @PostMapping("/volunteers")
    public Volunteer createVolunteer(@RequestBody Volunteer volunteer){
        return volunteerRepository.createVolunteer(volunteer);
    }

    @GetMapping("/volunteers")
    public List<Volunteer> getAllVolunteer(){

        return volunteerRepository.getAllVolunteer();
    }

    @GetMapping("/volunteers/{id}")
    public Volunteer getVolunteerById(@PathVariable("id") Integer id){
        return volunteerRepository.getVolunteerById(id);
    }

    @PutMapping("/volunteers/{id}")
    public Volunteer updateVolunteerById(@PathVariable("id") Integer id,@RequestBody @Validated @NonNull Volunteer volunteer){
        return volunteerRepository.updateVolunteerById(id,volunteer);
    }

    @DeleteMapping("/volunteers/{id}")
    public void  deleteVolunteerById(@PathVariable("id") Integer id){
        volunteerRepository.deleteVolunteerById(id);
    }



}
