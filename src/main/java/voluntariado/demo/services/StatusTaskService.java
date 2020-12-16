package voluntariado.demo.services;

import org.springframework.web.bind.annotation.*;
import voluntariado.demo.models.StatusTask;
import voluntariado.demo.repositories.StatusTaskRepository;

import java.util.List;

@CrossOrigin
@RestController
public class StatusTaskService {
    private final StatusTaskRepository statusTaskRepository;

    public StatusTaskService(StatusTaskRepository statusTaskRepository) {
        this.statusTaskRepository = statusTaskRepository;
    }
    @PostMapping("/statustasks")
    public StatusTask createStatusTask(@RequestBody StatusTask statusTask){
        return statusTaskRepository.createStatusTask(statusTask);
    }
    @GetMapping("/statustasks")
    public List<StatusTask> getAllStatusTask(){
        return statusTaskRepository.getAllStatusTask();
    }

    @GetMapping("/statustasks/{id}")
    public StatusTask getStatusTaskById(@PathVariable("id") Integer id){
        return statusTaskRepository.getStatusTaskById(id);
    }

    @PutMapping("/statustasks/{id}")
    public StatusTask updateStatusTaskById(@PathVariable("id")Integer id,@RequestBody StatusTask statusTask){
        return statusTaskRepository.updateStatusTaskById(id,statusTask);
    }

    @DeleteMapping("/statustasks/{id}")
    public void deleteStatusTaskById(@PathVariable("id") Integer id){
        statusTaskRepository.deleteStatusTaskById(id);
    }

}
