package grhapp.services.Grade;

import java.util.List;
import java.util.Optional;

import grhapp.Dto.GradeDto;
import grhapp.entites.Grade;

public interface GradeService {
    List<Grade> getAllGrades();
    Optional<Grade> getGradeById(Long id);
    Grade saveGrade(Grade grade);
    void deleteGrade(Long id);
    Optional<GradeDto> getGradeDetailsById(Long id);
}