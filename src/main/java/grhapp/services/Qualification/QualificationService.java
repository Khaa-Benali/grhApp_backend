package grhapp.services.Qualification;

import java.util.List;
import java.util.Optional;

import grhapp.entites.Qualification;

public interface QualificationService {
    List<Qualification> getAllQualifications();
    Optional<Qualification> getQualificationById(Long id);
    Qualification saveQualification(Qualification qualification);
    void deleteQualification(Long id);


}
