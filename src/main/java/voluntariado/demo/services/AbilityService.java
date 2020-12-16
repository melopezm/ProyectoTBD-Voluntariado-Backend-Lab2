package voluntariado.demo.services;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import voluntariado.demo.repositories.AbilityRepository;
import voluntariado.demo.models.Ability;

import java.util.List;

@CrossOrigin
@RestController
public class AbilityService
{
    private final AbilityRepository abiRepo;
    AbilityService ( AbilityRepository abiRepo )
    {
        this.abiRepo = abiRepo;
    }

    @PostMapping( "/abilities" )
    public Ability createAbility(@RequestBody Ability ability)
    {
        return abiRepo.createAbility( ability );
    }

    @GetMapping( "/abilities" )
    public List<Ability> getAllAbility()
    {
        return abiRepo.getAllAbility();
    }

    @GetMapping("/abilities/{id}")
    public Ability getAbilityById(@PathVariable( "id" ) Integer id)
    {
        return abiRepo.getAbilityById( id );
    }

    @PutMapping("/abilities/{id}")
    public Ability updateAbilityById(@PathVariable( "id" ) Integer id,@RequestBody @Validated @NonNull Ability ability)
    {
        return abiRepo.updateAbilityById( id, ability );
    }

    @DeleteMapping("/abilities/{id}")
    public void deleteAbilityById(@PathVariable( "id" ) Integer id){
        abiRepo.deleteAbilityById( id );
    }
}