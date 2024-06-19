package grhapp.services.Contrat;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grhapp.entites.Contrat;
import grhapp.entites.Document;
import grhapp.repositories.ContratRepository;
import grhapp.repositories.DocumentRepository;

@Service
public class ContratServiceImpl implements ContratService{
	@Autowired
	private DocumentRepository documentRepository;
	@Autowired
	private ContratRepository contratRepository;

	@Override
	public List<Contrat> getAllContrats() {
	return contratRepository.findAll();
	}

	@Override
	public Optional<Contrat> getContratById(Long id) {
		return contratRepository.findById(id);
		}

	@Override
	public Contrat saveContrat(Contrat contrat) {
	    contrat = contratRepository.save(contrat);

	    List<Document> documents = contrat.getDocuments();
	    if (documents != null && !documents.isEmpty()) {
	        for (Document document : documents) {
	            if (document.getId() == null) {
	                document.setContrat(contrat);
	                documentRepository.save(document);
	            }
	        }
	    }
	    return contrat;
	}
	@Override
	public void deleteContrat(Long id) {
		 contratRepository.deleteById(id);
		
	}

}
