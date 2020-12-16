package voluntariado.demo.repositories;

import voluntariado.demo.models.TaskAbility;

import java.util.List;

public interface TaskAbilityRepository {
    public List<TaskAbility> getAllTaskAbility();
    public TaskAbility getTaskAbilityById(Integer id);
    public void deleteTaskAbilityById(Integer id);
    public TaskAbility updateTaskAbilityById(Integer id, TaskAbility taskAbility);
    public TaskAbility createTaskAbility(TaskAbility taskAbility);
}
