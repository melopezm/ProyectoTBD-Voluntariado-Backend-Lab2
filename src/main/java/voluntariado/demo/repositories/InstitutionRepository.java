package voluntariado.demo.repositories;

import voluntariado.demo.models.Institution;
import java.util.List;

public interface InstitutionRepository
{
    public List<Institution> getAllInstitution();
    public Institution getInstitutionById( Integer id );
    public void deleteInstitutionById( Integer id );
    public Institution updateInstitutionById( Integer id, Institution institution );
    public Institution createInstitution( Institution institution );
}