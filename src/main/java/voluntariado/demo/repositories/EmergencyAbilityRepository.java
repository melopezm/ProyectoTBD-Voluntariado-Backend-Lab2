package voluntariado.demo.repositories;

import voluntariado.demo.models.EmergencyAbility;

import java.util.List;

public interface EmergencyAbilityRepository {

    public List<EmergencyAbility> getAllEmergencyAbility();
    public EmergencyAbility createEmergencyAbility( EmergencyAbility emergencyAbility );
    public EmergencyAbility getEmergencyAbilityById( Integer id );
    public EmergencyAbility updateEmergencyAbilityById( EmergencyAbility emergencyAbility, Integer id );
    public void deleteEmergencyAbility( Integer id );
}