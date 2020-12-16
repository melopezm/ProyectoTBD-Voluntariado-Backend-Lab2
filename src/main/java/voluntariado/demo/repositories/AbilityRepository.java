package voluntariado.demo.repositories;


import voluntariado.demo.models.Ability;

import java.util.List;


public interface AbilityRepository
{
    public List<Ability> getAllAbility();
    public Ability getAbilityById( Integer id );
    public void deleteAbilityById( Integer id );
    public Ability updateAbilityById( Integer id, Ability ability );
    public Ability createAbility( Ability ability );
}