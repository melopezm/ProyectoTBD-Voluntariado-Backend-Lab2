package voluntariado.demo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import voluntariado.demo.models.Institution;

import java.util.List;

@Repository
public class InstitutionRepositoryImplementation implements InstitutionRepository
{
    @Autowired
    private Sql2o sql2o;


    @Override
    public List<Institution> getAllInstitution()
    {
        try ( Connection conn = sql2o.open() )
        {
            return conn.createQuery( "SELECT * FROM institucion" ).executeAndFetch( Institution.class );
        }

        catch ( Exception e )
        {
            System.out.println( e.getMessage() );
            return null;
        }
    }

    @Override
    public Institution getInstitutionById( Integer id )
    {
        try( Connection con = sql2o.open() )
        {
            return con.createQuery( "SELECT * FROM institution WHERE id = :id" )
                    .addParameter( "id", id )
                    .executeAndFetchFirst( Institution.class );

        }
        catch ( Exception e )
        {
            System.out.println( e.getMessage() );
            return null;
        }
    }

    @Override
    public void deleteInstitutionById( Integer id )
    {
        try ( Connection conn = sql2o.open() )
        {
            conn.createQuery( "DELETE FROM institution WHERE id = :id" )
                    .addParameter( "id",id ).executeUpdate();
        }
        catch ( Exception e )
        {
            System.out.println( e.getMessage() );
        }
    }

    @Override
    public Institution updateInstitutionById( Integer id, Institution institution )
    {
        try ( Connection conn = sql2o.open() )
        {
            conn.createQuery( "UPDATE institucion SET nombre = :nombre WHERE id = :id" )
                    .addParameter( "nombre", institution.getNombre() )
                    .addParameter( "id", id ).executeUpdate();
            institution.setId( id );
            return institution;
        }
        catch ( Exception e )
        {
            System.out.println( e.getMessage() );
            return null;
        }
    }

    @Override
    public Institution createInstitution( Institution institution )
    {
        int idMax = 0;
        try ( Connection conn = sql2o.open() )
        {
            idMax = conn.createQuery( "SELECT CASE WHEN MAX(id) IS NULL THEN 0 ELSE MAX(id) END FROM institucion" ).executeScalar( Integer.class ) + 1;
            conn.createQuery( "INSERT INTO institucion(id,nombre) " + "VALUES (:id,:nombre)")
                    .addParameter( "id", idMax )
                    .addParameter( "nombre", institution.getNombre() )
                    .executeUpdate();
            institution.setId( idMax );
            return institution;
        }
        catch ( Exception e )
        {
            System.out.println( e.getMessage() );
            return null;
        }
    }

}