package voluntariado.demo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import voluntariado.demo.models.EmergencyAbility;

import java.util.List;

@Repository
public class EmergencyAbilityRepositoryImplementation implements EmergencyAbilityRepository {

    @Autowired
    private Sql2o sql2o;


    @Override
    public List<EmergencyAbility> getAllEmergencyAbility()
    {
        try ( Connection conn = sql2o.open() )
        {
            return conn.createQuery( "SELECT * FROM eme_habilidad" ).executeAndFetch( EmergencyAbility.class );
        }
        catch ( Exception e )
        {
            System.out.println( e.getMessage() );
            return null;
        }
    }

    @Override
    public EmergencyAbility createEmergencyAbility( EmergencyAbility emergencyAbility )
    {
        int idMax = 0;
        final String sql = "INSERT INTO eme_habilidad (id_emergencia, id_habilidad) VALUES (:idEme, :idHab)";

        try ( Connection conn = sql2o.open() )
        {
            idMax = conn.createQuery( "SELECT CASE WHEN MAX(id) IS NULLL THEN 0 ELSE MAX(id) END FROM eme_habilidad" ).executeScalar( Integer.class ) + 1;
            conn.createQuery( sql )
                    .addParameter( "idEme", emergencyAbility.getId_emergencia() )
                    .addParameter( "idHab", emergencyAbility.getId_habilidad() ).executeUpdate();
            emergencyAbility.setId(idMax);
            return emergencyAbility;
        }
        catch ( Exception e )
        {
            System.out.println( e.getMessage() );
            return null;
        }
    }

    @Override
    public EmergencyAbility getEmergencyAbilityById( Integer id )
    {
        try ( Connection conn = sql2o.open() )
        {
            return conn.createQuery( "SELECT * FROM eme_habilidad WHERE id = :id" )
                    .addParameter( "id", id )
                    .executeAndFetch( EmergencyAbility.class ).get( 0 );
        }
        catch ( Exception e )
        {
            System.out.println( e.getMessage() );
            return null;
        }
    }

    @Override
    public EmergencyAbility updateEmergencyAbilityById( EmergencyAbility emergencyAbility, Integer id )
    {
        String sql = "UPDATE eme_habilidad SET id_emergencia = :idEme, id_habilidad = :idHab WHERE id = :eme_habId";

        try ( Connection conn = sql2o.open() )
        {
            conn.createQuery( sql, true )
                    .addParameter("idEme", emergencyAbility.getId_emergencia())
                    .addParameter("idHab", emergencyAbility.getId_habilidad())
                    .addParameter("eme_habId", id)
                    .executeUpdate();
            emergencyAbility.setId(id);
            return emergencyAbility;
        }
        catch ( Exception e )
        {
            System.out.println( e.getMessage() );
            return null;
        }
    }

    @Override
    public void deleteEmergencyAbility( Integer id )
    {
        try ( Connection conn = sql2o.open() ) {
            conn.createQuery("DELETE FROM eme_habilidad WHERE id = :eme_habId")
                    .addParameter("eme_habId", id).executeUpdate();

        } catch ( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }
}