package voluntariado.demo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import voluntariado.demo.models.StatusTask;

import java.util.List;

@Repository
public class StatusTaskRepositoryImplementation implements StatusTaskRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public StatusTask createStatusTask(StatusTask statusTask) {
        final String sql = "SELECT CASE WHEN MAX(id) IS NULL THEN 0 ELSE MAX(id) END FROM estado_tarea";
        final String sql1 = "INSERT INTO estado_tarea(id,descrip) VALUES (:id,:descrip)";
        try(Connection conn = sql2o.open()){
            int max = conn.createQuery(sql).executeScalar(Integer.class) + 1;
            conn.createQuery(sql1)
                    .addParameter("id",max)
                    .addParameter("descrip",statusTask.getDescrip())
                    .executeUpdate();
            statusTask.setId(max);
            return statusTask;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<StatusTask> getAllStatusTask() {
        final String sql = "SELECT * FROM estado_tarea";
        try(Connection conn =sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(StatusTask.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public StatusTask getStatusTaskById(Integer id) {
        final String sql = "SELECT * FROM estado_tarea WHERE id = :id";
        try(Connection conn= sql2o.open()){
            StatusTask statusTask = conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(StatusTask.class);
            return statusTask;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public StatusTask updateStatusTaskById(Integer id, StatusTask statusTask) {
        final String sql = "UPDATE estado_tarea SET descrip = :descrip WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .addParameter("descrip",statusTask.getDescrip())
                    .executeUpdate();
            statusTask.setId(id);
            return statusTask;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteStatusTaskById(Integer id) {
        final String sql= "DELETE FROM estado_tarea WHERE id = :id";
        try (Connection conn =sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
