package grhapp.services.Qualification;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grhapp.entites.Qualification;
import grhapp.repositories.QualificationRepository;

@Service
public class QualificationServiceImpl implements QualificationService {

	@Autowired
	private QualificationRepository qualificationRepository;
	@Override
	public List<Qualification> getAllQualifications() {
		return qualificationRepository.findAll();
	}

	@Override
	public Optional<Qualification> getQualificationById(Long id) {
		return qualificationRepository.findById(id);
	}

	@Override
	public Qualification saveQualification(Qualification qualification) {
		return qualificationRepository.save(qualification);
	}

	@Override
	public void deleteQualification(Long id) {
		qualificationRepository.deleteById(id);
		
	}

}
