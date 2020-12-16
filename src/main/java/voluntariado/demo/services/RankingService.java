package voluntariado.demo.services;


import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import voluntariado.demo.models.Ranking;
import voluntariado.demo.repositories.RankingRepository;

import java.util.List;

@CrossOrigin
@RestController

public class RankingService {
    private final RankingRepository rankingRepository;

    public RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    @PostMapping("/ranking")
    public Ranking createEmergency(@RequestBody Ranking ranking){
        return rankingRepository.createRanking(ranking);
    }

    @GetMapping("/ranking")
    public List<Ranking> getAllRanking(){
        return rankingRepository.getAllRanking();
    }

    @GetMapping("/ranking/{id}")
    public Ranking getRankingById(@PathVariable("id") Integer id){
        return rankingRepository.getRankingById(id);
    }

    @PutMapping("/ranking/{id}")
    public Ranking updateRankingById(@PathVariable("id") Integer id,@RequestBody @Validated @NonNull Ranking ranking){
        return rankingRepository.updateRankingById(id,ranking);
    }

    @DeleteMapping("/ranking/{id}")
    public void deleteRankingById(@PathVariable("id") Integer id){
        rankingRepository.deleteRankingById(id);
    }
}
