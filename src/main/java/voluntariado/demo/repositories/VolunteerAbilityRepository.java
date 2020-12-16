package voluntariado.demo.repositories;

import voluntariado.demo.models.VolunteerAbility;

import java.util.List;

public interface VolunteerAbilityRepository {
    public List<VolunteerAbility> getAllVolunteerAbility();
    public VolunteerAbility getVolunteerAbilityById(Integer id);
    public void deleteVolunteerAbilityById(Integer id);
    public VolunteerAbility updateVolunteerAbilityById(Integer id, VolunteerAbility volunteerAbility);
    public VolunteerAbility createVolunteerAbility(VolunteerAbility volunteerAbility);
}
