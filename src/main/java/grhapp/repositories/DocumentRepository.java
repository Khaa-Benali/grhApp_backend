package grhapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import grhapp.entites.Document;

public interface DocumentRepository  extends JpaRepository<Document, Long>{

}
