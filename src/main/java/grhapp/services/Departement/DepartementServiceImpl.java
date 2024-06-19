package grhapp.services.Departement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grhapp.entites.Departement;
import grhapp.repositories.DepartementRepository;

@Service
public class DepartementServiceImpl implements DepartementService{
	
	private final DepartementRepository departementRepository;
	 @Autowired
	    public DepartementServiceImpl(DepartementRepository departementRepository) {
	        this.departementRepository = departementRepository;
	    }


	@Override
	public List<Departement> getAllDepartements() {
		   return departementRepository.findAll();
	
	}

	@Override
	public Optional<Departement> getDepartementById(Long id) {
		return departementRepository.findById(id);
		
	}

	@Override
	public Departement saveDepartement(Departement departement) {
		return departementRepository.save(departement);
		
	}

	@Override
	public void deleteDepartement(Long id) {
		departementRepository.deleteById(id);
	}

}
