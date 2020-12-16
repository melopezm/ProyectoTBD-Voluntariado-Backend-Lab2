package voluntariado.demo.repositories;

import voluntariado.demo.models.Emergency;

import java.util.List;

public interface EmergencyRepository {
    public List<Emergency> getAllEmergency();
    public Emergency createEmergency(Emergency emergency);
    public void deleteEmergencyById(Integer id);
    public Emergency getEmergencyById(Integer id);
    public Emergency updateEmergencyById(Integer id, Emergency emergency);
}
