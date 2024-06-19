package grhapp.services.Document;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grhapp.entites.Document;
import grhapp.repositories.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService {
	@Autowired
	private DocumentRepository documentRepository;
	

	@Override
	public List<Document> getAllDocuments() {
	return documentRepository.findAll();
	}

	@Override
	public Optional<Document> getDocumentById(Long id) {
		return documentRepository.findById(id);
	}

	@Override
	public Document saveDocument(Document documet) {
		return documentRepository.save(documet);
	}

	@Override
	public void deleteDocument(Long id) {
		documentRepository.deleteById(id);
		
	}

}
