package grhapp.services.Grade;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grhapp.Dto.GradeDto;
import grhapp.entites.Grade;
import grhapp.repositories.DepartementRepository;
import grhapp.repositories.GradeRepository;
import grhapp.repositories.PosteRepository;

@Service
public class GradeServiceImpl implements GradeService{
	   @Autowired
	    private PosteRepository posteRepository;

	    @Autowired
	    private DepartementRepository departementRepository;
	  private final GradeRepository gradeRepository;

	    @Autowired
	    public GradeServiceImpl(GradeRepository gradeRepository) {
	        this.gradeRepository = gradeRepository;
	    }

	    @Override
	    public List<Grade> getAllGrades() {
	        return gradeRepository.findAll();
	    }

	    @Override
	    public Optional<Grade> getGradeById(Long id) {
	        return gradeRepository.findById(id);
	    }

	    @Override
	    public Grade saveGrade(Grade grade) {
	      
	        if (grade.getPoste() == null || grade.getDepartement() == null) {
	            throw new IllegalArgumentException("Poste et departement ne peuvent pas être nulles");
	        }

	        if (grade.getPoste().getId() == null) {
	            posteRepository.save(grade.getPoste());
	        }
	        if (grade.getDepartement().getId() == null) {
	            departementRepository.save(grade.getDepartement());
	        }
	        return gradeRepository.save(grade);
	    }

	    @Override
	    public void deleteGrade(Long id) {
	        gradeRepository.deleteById(id);
	    }

	    @Override
	    public Optional<GradeDto> getGradeDetailsById(Long id) {
	    	 Optional<Grade> grade = gradeRepository.findById(id);
	         return grade.map(Grade::getGradeDeatilstDto);
	    }

}
