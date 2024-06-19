package grhapp.services.poste;

import java.util.List;
import java.util.Optional;

import grhapp.entites.Poste;

public interface PosteService {
	    List<Poste> getAllPostes();
	    Optional<Poste> getPosteById(Long id);
	    Poste savePoste(Poste poste);
	    void deletePoste(Long id);

}
