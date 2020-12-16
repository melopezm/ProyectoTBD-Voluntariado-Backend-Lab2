package voluntariado.demo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import voluntariado.demo.models.Task;

import java.util.List;

@Repository
public class TaskRepositoryImplementation implements TaskRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Task createTask(Task task) {
        final String sql1 = "SELECT CASE WHEN MAX(id) IS NULL THEN 0 ELSE MAX(id) END FROM tarea";
        final String sql = "INSERT INTO tarea(id,nombre,descrip,cant_vol_requeridos,cant_vol_inscritos,id_emergencia" +
                ",finicio,ffin,id_estado) VALUES(:id,:n,:d,:car,:cai,:ide,:fi,:ff,:ie)";
        try(Connection conn =sql2o.open()){
            int idMax = conn.createQuery(sql1).executeScalar(Integer.class)+1;
            conn.createQuery(sql)
                    .addParameter("id",idMax)
                    .addParameter("n",task.getNombre())
                    .addParameter("d",task.getDescrip())
                    .addParameter("car",task.getCant_vol_requeridos())
                    .addParameter("cai",0)
                    .addParameter("ide",task.getId_emergencia())
                    .addParameter("fi",task.getFinicio())
                    .addParameter("ff",task.getFfin())
                    .addParameter("ie",0)
                    .executeUpdate();
            task.setId(idMax);
            task.setCant_vol_inscritos(0);
            task.setId_estado(0);
            return task;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Task> getAllTask() {
        final String sql="SELECT * FROM tarea";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(Task.class);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Task getTaskById(Integer id) {
        final String sql = "SELECT * FROM tarea WHERE id = :id";
        try(Connection conn = sql2o.open()) {
            Task task = conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Task.class);
            return task;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Task updateTaskById(Integer id,Task task) {
        final String sql = "UPDATE tarea SET nombre = :n," +
                "descrip = :d, cant_vol_requeridos = :car, " +
                "cant_vol_inscritos =:cai, id_emergencia = :ie," +
                "finicio = :fi, ffin = :ff,id_estado = :ide WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("n",task.getNombre())
                    .addParameter("d",task.getDescrip())
                    .addParameter("car",task.getCant_vol_requeridos())
                    .addParameter("cai",task.getCant_vol_inscritos())
                    .addParameter("ie",task.getId_emergencia())
                    .addParameter("fi",task.getFfin())
                    .addParameter("ff",task.getFfin())
                    .addParameter("ide",task.getId_estado())
                    .addParameter("id",id)
                    .executeUpdate();
            task.setId(id);
            return task;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteTaskById(Integer id) {
        final String sql = "DELETE FROM tarea WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
