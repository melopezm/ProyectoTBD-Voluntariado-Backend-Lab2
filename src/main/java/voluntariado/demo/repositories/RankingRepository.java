package voluntariado.demo.repositories;

import voluntariado.demo.models.Ranking;

import java.util.List;

public interface RankingRepository {
    public List<Ranking> getAllRanking();
    public Ranking createRanking(Ranking ranking);
    public void deleteRankingById(Integer id);
    public Ranking getRankingById(Integer id);
    public Ranking updateRankingById(Integer id, Ranking ranking);
}
