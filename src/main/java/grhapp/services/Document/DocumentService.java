package grhapp.services.Document;

import java.util.List;
import java.util.Optional;

import grhapp.entites.Document;

public interface DocumentService {
	   List<Document> getAllDocuments();
	    Optional<Document> getDocumentById(Long id);
	    Document saveDocument(Document documet);
	    void deleteDocument(Long id);
}
