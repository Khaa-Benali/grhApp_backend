package grhapp.services.poste;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grhapp.entites.Poste;
import grhapp.repositories.PosteRepository;
@Service
public class PosteServiceImpl implements PosteService{
	
	  @Autowired
	    private  PosteRepository posteRepository ;


	    @Override
	    public List<Poste> getAllPostes() {
	        return posteRepository.findAll();
	    }

	    @Override
	    public Optional<Poste> getPosteById(Long id) {
	        return posteRepository.findById(id);
	    }

	    @Override
	    public Poste savePoste(Poste poste) {
	         return posteRepository.save(poste);
	    }

	    @Override
	    public void deletePoste(Long id) {
	        posteRepository.deleteById(id);
	    }

}
