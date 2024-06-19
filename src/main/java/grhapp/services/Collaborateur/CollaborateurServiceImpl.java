package grhapp.services.Collaborateur;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grhapp.Dto.CollaborateurDto;
import grhapp.entites.Collaborateur;
import grhapp.entites.Contrat;
import grhapp.entites.Grade;
import grhapp.repositories.CollaborateurRepository;
import grhapp.repositories.ContratRepository;
import grhapp.repositories.GradeRepository;
import grhapp.repositories.QualificationRepository;
import grhapp.services.Contrat.ContratService;
import grhapp.services.Grade.GradeService;

@Service
public class CollaborateurServiceImpl implements CollaborateurService{
	 @Autowired
	private  CollaborateurRepository collaborateurRepository;
	 @Autowired
	    private ContratService contratService;
	 @Autowired
	    private GradeService gradeService;

	    @Autowired
	    private GradeRepository gradeRepository;

	    @Autowired
	    private QualificationRepository qualificationRepository;


    @Override
    public List<CollaborateurDto> getAllCollaborateurs() {
        List<Collaborateur> collaborateurs = collaborateurRepository.findAll();
        return collaborateurs.stream()
                .map(Collaborateur::getCollaborateurDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Collaborateur> getCollaborateurById(Long id) {
        return collaborateurRepository.findById(id);
    }



    @Override
    public void deleteCollaborateur(Long id) {
        collaborateurRepository.deleteById(id);
    }

    @Override
    public double calculMasseSalariale() {
        List<Collaborateur> collaborateurs = collaborateurRepository.findAll();
        return collaborateurs.stream()
                             .filter(c -> c.getContrat() != null)
                             .mapToDouble(c -> c.getContrat().getBaseSalary())
                             .sum();
    }

	@Override
	public Collaborateur ajouterCollaborateur(Collaborateur collaborateur) {
		 Collaborateur existingCollaborateur = collaborateurRepository.findByCin(collaborateur.getCin());
		 if (existingCollaborateur != null) {
		        throw new IllegalArgumentException("Le collaborateur avec le numéro de CIN " + collaborateur.getCin() + " existe déjà.");
		    }
		 if (collaborateur.getQualification().getId() == null) {
		     qualificationRepository.save(collaborateur.getQualification());
		     
		 }
		 if (collaborateur.getGrade().getId() == null) {
			 gradeService.saveGrade(collaborateur.getGrade());
		     
		 }
		 if (collaborateur.getContrat().getId() == null) {
			 contratService.saveContrat(collaborateur.getContrat());
		     
		 }
		        return collaborateurRepository.save(collaborateur);
		      
}
}