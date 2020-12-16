package voluntariado.demo.services;

import org.springframework.web.bind.annotation.*;
import voluntariado.demo.models.Task;
import voluntariado.demo.repositories.TaskRepository;

import java.util.List;

@CrossOrigin
@RestController
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task){
        return taskRepository.createTask(task);
    }

    @GetMapping("/tasks")
    public List<Task> getAllTask(){
        return taskRepository.getAllTask();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable("id") Integer id){
        return taskRepository.getTaskById(id);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTaskById(@PathVariable("id") Integer id,@RequestBody Task task){
        return taskRepository.updateTaskById(id,task);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTaskById(@PathVariable("id") Integer id){
        taskRepository.deleteTaskById(id);
    }
}
