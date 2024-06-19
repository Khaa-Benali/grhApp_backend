package grhapp.entites;
import java.util.Set;

import grhapp.Dto.DepartementDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "Departement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departement {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDepartement;
	private String nom;
    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Grade> grades;
	public Long getId() {
		return idDepartement;
	}
	public void setId(Long id) {
		this.idDepartement = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Set<Grade> getGrades() {
		return grades;
	}
	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}
	
	public DepartementDto getDepartementDto() {
		DepartementDto departementDto = new DepartementDto();
		departementDto.setIdDepartement(idDepartement);
		departementDto.setNom(nom);
		return departementDto; 
		
	}
    
}
