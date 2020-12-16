package voluntariado.demo.services;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import voluntariado.demo.repositories.InstitutionRepository;
import voluntariado.demo.models.Institution;

import java.util.List;

@CrossOrigin
@RestController
public class InstitutionService
{
    private final InstitutionRepository insRepo;
    InstitutionService ( InstitutionRepository insRepo )
    {
        this.insRepo = insRepo;
    }

    @GetMapping( "/institution/all" )
    public List<Institution> getAllInstitution()
    {
        return insRepo.getAllInstitution();
    }

    @PostMapping( "/institution/add" )
    @ResponseBody
    public Institution createInstitution( @RequestBody Institution institution )
    {
        return insRepo.createInstitution( institution );
    }

    @GetMapping( "/institution/{id}" )
    public Institution getInstitutionById( @PathVariable(value = "id") Integer id )
    {
        return insRepo.getInstitutionById(id);
    }

    @PutMapping( "/institution/update/{id}" )
    @ResponseBody
    public Institution updateInstitutionById( @RequestBody Institution institution, @PathVariable(value = "id") Integer id )
    {
        return insRepo.updateInstitutionById( id, institution );
    }

    @DeleteMapping( "/institution/delete/{id}" )
    public void deleteInstitution( @PathVariable(value = "id") Integer id )
    {
        insRepo.deleteInstitutionById(id);
    }
}
