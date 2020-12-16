package voluntariado.demo.repositories;


import voluntariado.demo.models.Volunteer;

import java.util.List;


public interface VolunteerRepository {
    public List<Volunteer> getAllVolunteer();
    public Volunteer getVolunteerById(Integer id);
    public  void deleteVolunteerById(Integer id);
    public Volunteer updateVolunteerById(Integer id, Volunteer volunteer);
    public Volunteer createVolunteer(Volunteer volunteer);
}
