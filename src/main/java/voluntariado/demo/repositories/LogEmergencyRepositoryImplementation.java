package voluntariado.demo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import voluntariado.demo.models.Emergency;
import voluntariado.demo.models.LogEmergency;

import java.util.List;

@Repository
public class LogEmergencyRepositoryImplementation implements LogEmergencyRepository{
    @Autowired
    private Sql2o sql2o;
    @Override
    public List<LogEmergency> getAllLogEmergency() {
        final String sql = "SELECT * FROM log_emergencia";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(LogEmergency.class);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public LogEmergency getLogEmergencyById(Integer id) {
        final String sql = "SELECT * FROM log_emergencia WHERE id = :id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql).addParameter("id",id).executeAndFetchFirst(LogEmergency.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
