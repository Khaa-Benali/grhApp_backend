package grhapp.entites;

import grhapp.Dto.DocumentDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PiecesJointes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDoc;
	private String nom;
	private String type;
	private boolean isMandatory;
   @ManyToOne
   @JoinColumn(name = "contrat_id")
   private Contrat contrat;
public Long getId() {
	return idDoc;
}
public void setId(Long id) {
	this.idDoc = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public boolean isMandatory() {
	return isMandatory;
}
public void setMandatory(boolean isMandatory) {
	this.isMandatory = isMandatory;
}
public Contrat getContrat() {
	return contrat;
}
public void setContrat(Contrat contrat) {
	this.contrat = contrat;
}
public DocumentDto getDocumentDto() {
	DocumentDto documentDto = new DocumentDto();
	documentDto.setIdDoc(idDoc);
	documentDto.setNom(nom);
	documentDto.setMandatory(isMandatory);
	documentDto.setType(type);
	documentDto.setContrat(contrat);
	return documentDto;
}

}
