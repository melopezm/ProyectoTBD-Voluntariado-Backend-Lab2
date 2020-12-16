package voluntariado.demo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import voluntariado.demo.models.TaskAbility;
import java.util.List;

@Repository
public class TaskAbilityImplementation implements TaskAbilityRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<TaskAbility> getAllTaskAbility(){
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM tarea_habilidad").executeAndFetch(TaskAbility.class);
        }
        catch (Exception e)
        {
            System.out.println( e.getMessage() );
            return null;
        }
    }


    @Override
    public TaskAbility getTaskAbilityById(Integer id) {
        final String sql="SELECT * FROM tarea_habilidad where id = :id";
        try(Connection con = sql2o.open()){
            TaskAbility taskAbility = con.createQuery(sql).addParameter("id",id).executeAndFetchFirst(TaskAbility.class);
            return taskAbility;
        }
        catch (Exception e)
        {
            System.out.println( e.getMessage() );
            return null;
        }
    }


    @Override
    public void deleteTaskAbilityById(Integer id) {
        final String sql = "DELETE FROM tarea_habilidad WHERE id = :id";
        try (Connection conn = sql2o.open()){
            conn.createQuery(sql).addParameter("id",id).executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @Override
    public TaskAbility updateTaskAbilityById(Integer id, TaskAbility taskAbility) {
        final String sql = "UPDATE tarea_habilidad SET id_emehab = :id_emehab,id_tarea = :id_tarea WHERE id = :id ";
        try (Connection conn = sql2o.open()){
            conn.createQuery(sql,true)
                    .addParameter("id_emehab",taskAbility.getId_emehab())
                    .addParameter("id_tarea",taskAbility.getId_tarea())
                    .addParameter("id",id)
                    .executeUpdate();
            taskAbility.setId(id);
            return taskAbility;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public TaskAbility createTaskAbility(TaskAbility taskAbility) {
        int idMax = 0;
        try(Connection conn =sql2o.open()){
            idMax = conn.createQuery("SELECT CASE WHEN MAX(id) IS NULL THEN 0 ELSE MAX(id) END FROM tarea_habilidad").executeScalar(Integer.class)+1;
            conn.createQuery("INSERT INTO tarea_habilidad(id,id_emehab,id_tarea) " + "VALUES (:id,:id_emehab,:id_tarea)")
                    .addParameter("id",idMax)
                    .addParameter("id_emehab",taskAbility.getId_emehab())
                    .addParameter("id_tarea",taskAbility.getId_tarea())
                    .executeUpdate();
            taskAbility.setId(idMax);
            return taskAbility;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }














}
