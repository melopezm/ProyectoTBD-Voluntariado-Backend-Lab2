package voluntariado.demo.repositories;

import voluntariado.demo.models.Emergency;
import voluntariado.demo.models.LogEmergency;

import java.util.List;

public interface LogEmergencyRepository {
    public List<LogEmergency> getAllLogEmergency();
    public LogEmergency getLogEmergencyById(Integer id);
}
