package voluntariado.demo.services;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import voluntariado.demo.models.LogTask;
import voluntariado.demo.repositories.LogTaskRepository;

import java.util.List;

@CrossOrigin
@RestController
public class LogTaskService {
    private final LogTaskRepository logTaskRepository;

    public LogTaskService(LogTaskRepository logTaskRepository) {
        this.logTaskRepository = logTaskRepository;
    }
    @GetMapping("/logTasks")
    public List<LogTask> getAllLogTask(){return logTaskRepository.getAllLogTask();}

    @GetMapping("/logTasks/{id}")
    public LogTask getLogTaskById(@PathVariable(value = "id") Integer id){return logTaskRepository.getLogTaskById(id);}
}
