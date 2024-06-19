package grhapp.entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import grhapp.Dto.ContratDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "Contrats")
public class Contrat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContrat;
	
	private Date dateD;
	
	private Date dateF;
	private Double baseSalary;
	
	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	@OneToOne(mappedBy = "contrat")
	private Collaborateur collaborateur;
	

    private String typeContrat;
    
    @OneToMany(mappedBy = "contrat")
    private List<Document> documents;

	public Long getId() {
		return idContrat;
	}

	public void setId(Long id) {
		this.idContrat = id;
	}

	public Date getDateD() {
		return dateD;
	}

	public void setDateD(Date dateD) {
		this.dateD = dateD;
	}

	public Date getDateF() {
		return dateF;
	}

	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	} 
	public ContratDto getContratDto() {
        ContratDto contratDto = new ContratDto();
        contratDto.setDateDebut(this.dateD);
        contratDto.setDateFin(this.dateF);
        contratDto.setBaseSalary(this.baseSalary);
        contratDto.setTypeContrat(this.typeContrat);
        
        if (this.documents != null) {
            List<Long> documentIds = new ArrayList<>();
            for (Document document : this.documents) {
                documentIds.add(document.getId());
            }
            contratDto.setDocumentIds(documentIds);
        }

        return contratDto;
    }
}