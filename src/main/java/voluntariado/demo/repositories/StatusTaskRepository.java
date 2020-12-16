package voluntariado.demo.repositories;

import voluntariado.demo.models.StatusTask;

import java.util.List;

public interface StatusTaskRepository {
    public StatusTask createStatusTask(StatusTask statusTask);
    public List<StatusTask> getAllStatusTask();
    public StatusTask getStatusTaskById(Integer id);
    public StatusTask updateStatusTaskById(Integer id,StatusTask statusTask);
    public void deleteStatusTaskById(Integer id);
}
