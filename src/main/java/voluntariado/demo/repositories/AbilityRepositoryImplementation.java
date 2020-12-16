package voluntariado.demo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import voluntariado.demo.models.Ability;

import java.util.List;

@Repository
public class AbilityRepositoryImplementation implements AbilityRepository
{
    @Autowired
    private Sql2o sql2o;


    @Override
    public List<Ability> getAllAbility()
    {
        try ( Connection conn = sql2o.open() )
        {
            return conn.createQuery( "SELECT * FROM habilidad" ).executeAndFetch( Ability.class );
        }

        catch ( Exception e )
        {
            System.out.println( e.getMessage() );
            return null;
        }
    }

    @Override
    public Ability getAbilityById( Integer id )
    {
        try( Connection con = sql2o.open() )
        {
            return con.createQuery( "SELECT * FROM habilidad WHERE id = :id" ).addParameter( "id", id )
                    .executeAndFetchFirst(Ability.class);

        }
        catch ( Exception e )
        {
            System.out.println( e.getMessage() );
            return null;
        }
    }

    @Override
    public void deleteAbilityById( Integer id )
    {
        final String sql = "DELETE FROM habilidad WHERE id = :id";
        try (Connection conn = sql2o.open()){
            conn.createQuery( sql ).addParameter( "id",id ).executeUpdate();
        }
        catch ( Exception e )
        {
            System.out.println( e.getMessage() );
        }
    }

    @Override
    public Ability updateAbilityById( Integer id, Ability ability )
    {
        final String sql = "UPDATE habilidad SET descrip = :descrip WHERE id = :id";
        try ( Connection conn = sql2o.open() )
        {
            conn.createQuery( sql, true )
                    .addParameter( "descrip", ability.getDescrip() )
                    .addParameter( "id", id )
                    .executeUpdate();
            ability.setId(id);
            return ability;
        }
        catch ( Exception e )
        {
            System.out.println( e.getMessage() );
            return null;
        }
    }

    @Override
    public Ability createAbility( Ability ability )
    {
        int idMax = 0;
        try ( Connection conn = sql2o.open() )
        {
            idMax = conn.createQuery( "SELECT CASE WHEN MAX(id) IS NULL THEN 0 ELSE MAX(id) END FROM habilidad" ).executeScalar( Integer.class ) + 1;
            conn.createQuery( "INSERT INTO habilidad(id,descrip) " + "VALUES (:id,:descrip)")
                    .addParameter( "id", idMax )
                    .addParameter( "descrip", ability.getDescrip() )
                    .executeUpdate();
            ability.setId( idMax );
            return ability;
        }
        catch ( Exception e )
        {
            System.out.println( e.getMessage() );
            return null;
        }
    }
}