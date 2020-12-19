package voluntariado.demo.repositories;

import voluntariado.demo.models.LogTask;

import java.util.List;

public interface LogTaskRepository {
    public List<LogTask> getAllLogTask();
    public LogTask getLogTaskById(Integer id);
}
