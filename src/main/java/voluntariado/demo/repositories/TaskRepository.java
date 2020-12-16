package voluntariado.demo.repositories;


import voluntariado.demo.models.Task;

import java.util.List;

public interface TaskRepository {
    public Task createTask(Task task);
    public List<Task> getAllTask();
    public Task getTaskById(Integer id);
    public Task updateTaskById(Integer id, Task task);
    public void deleteTaskById(Integer id);
}
