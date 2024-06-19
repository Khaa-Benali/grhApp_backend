package grhapp.services.Contrat;

import java.util.List;
import java.util.Optional;

import grhapp.entites.Contrat;
public interface ContratService {
	   List<Contrat> getAllContrats();
	    Optional<Contrat> getContratById(Long id);
	    Contrat saveContrat(Contrat contrat);
	    void deleteContrat(Long id);

}
