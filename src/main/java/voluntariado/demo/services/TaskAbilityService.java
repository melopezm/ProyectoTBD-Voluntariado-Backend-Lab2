package voluntariado.demo.services;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import voluntariado.demo.models.TaskAbility;
import voluntariado.demo.repositories.TaskAbilityRepository;
import java.util.List;

@CrossOrigin
@RestController
public class TaskAbilityService {
    private final TaskAbilityRepository taskAbilityRepository;

    public TaskAbilityService(TaskAbilityRepository taskAbilityRepository) {this.taskAbilityRepository = taskAbilityRepository;}

    @PostMapping("/taskAbility")
    public TaskAbility createVolunteer(@RequestBody TaskAbility taskAbility){
        return taskAbilityRepository.createTaskAbility(taskAbility);
    }

    @GetMapping("/taskAbility")
    public List<TaskAbility> getAllTaskAbility(){
        return taskAbilityRepository.getAllTaskAbility();
    }

    @GetMapping("/taskAbility/{id}")
    public TaskAbility getTaskAbilityById(@PathVariable("id") Integer id){
        return taskAbilityRepository.getTaskAbilityById(id);
    }

    @PutMapping("/taskAbility/{id}")
    public TaskAbility updateTaskAbilityById(@PathVariable("id") Integer id,@RequestBody @Validated @NonNull TaskAbility taskAbility){
        return taskAbilityRepository.updateTaskAbilityById(id,taskAbility);
    }

    @DeleteMapping("/taskAbility/{id}")
    public void  deleteTaskAbilityById(@PathVariable("id") Integer id){
        taskAbilityRepository.deleteTaskAbilityById(id);
    }
}
