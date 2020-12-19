package voluntariado.demo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import voluntariado.demo.models.LogTask;

import java.util.List;

@Repository
public class LogTaskRepositoryImplementation implements LogTaskRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<LogTask> getAllLogTask() {
        final String sql = "SELECT * FROM log_tarea";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(LogTask.class);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public LogTask getLogTaskById(Integer id) {
        final String sql = "SELECT * FROM log_tarea WHERE id = :id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).addParameter("id",id).executeAndFetchFirst(LogTask.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
