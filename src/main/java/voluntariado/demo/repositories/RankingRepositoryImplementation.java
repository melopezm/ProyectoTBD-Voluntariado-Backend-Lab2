package voluntariado.demo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import voluntariado.demo.models.Ranking;

import java.util.List;

@Repository
public class RankingRepositoryImplementation implements RankingRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Ranking> getAllRanking() {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Ranking").executeAndFetch(Ranking.class);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Ranking createRanking(Ranking ranking) {
        int idMax = 0;
        try(Connection conn =sql2o.open()) {
            idMax = conn.createQuery("SELECT CASE WHEN MAX(id) IS NULL THEN 0 ELSE MAX(id) END FROM ranking").executeScalar(Integer.class)+1;
            conn.createQuery("INSERT INTO ranking(id,id_voluntario,id_tarea,puntaje,flg_invitado,flg_participa) " + "VALUES (:id,:id_voluntario,:id_tarea,:puntaje,:flg_invitado,:flg_participa)")
                    .addParameter("id",idMax)
                    .addParameter("id_voluntario",ranking.getId_voluntario())
                    .addParameter("id_tarea",ranking.getId_tarea())
                    .addParameter("puntaje",ranking.getPuntaje())
                    .addParameter("flg_invitado",ranking.getFlg_invitado())
                    .addParameter("flg_participa",ranking.getFlg_participa())
                    .executeUpdate();
            ranking.setId(idMax);
            return ranking;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteRankingById(Integer id) {
        final String sql = "DELETE FROM ranking WHERE id = :id";
        try (Connection conn = sql2o.open()){
            conn.createQuery(sql).addParameter("id",id).executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Ranking getRankingById(Integer id) {
        final String sql="SELECT * FROM emergency where id = :id";
        try(Connection conn = sql2o.open()){
            Ranking ranking = conn.createQuery(sql).addParameter("id",id).executeAndFetchFirst(Ranking.class);
            return ranking;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Ranking updateRankingById(Integer id, Ranking ranking) {
        final String sql = "UPDATE ranking SET id_voluntario = :id_voluntario,id_tarea = :id_tarea,puntaje = :puntaje,flg_invitado = :flg_invitado,flg_participa = :flg_participa WHERE id = :id ";
        try (Connection conn = sql2o.open()){
            conn.createQuery(sql,true)
                    .addParameter("id_voluntario",ranking.getId_voluntario())
                    .addParameter("id_tarea",ranking.getId_tarea())
                    .addParameter("puntaje",ranking.getPuntaje())
                    .addParameter("flg_invitado",ranking.getFlg_invitado())
                    .addParameter("flg_participa",ranking.getFlg_participa())
                    .addParameter("id",id)
                    .executeUpdate();
            ranking.setId(id);
            return ranking;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
