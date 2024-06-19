package grhapp.entites;

import java.util.Set;

import grhapp.Dto.GradeDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "Grades")
public class Grade {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGrade;
	@OneToMany(mappedBy = "grade", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Collaborateur> collaborateurs;
	
	 @ManyToOne
	 @JoinColumn(name = "departement_id", nullable = false)
	 private Departement departement;
	 @ManyToOne
	 @JoinColumn(name = "poste_id", nullable = false)
	  private  Poste poste;

	 public GradeDto getGradeDeatilstDto() {
		 GradeDto gradeDetailsDto = new GradeDto();
		 gradeDetailsDto.setGradeId(idGrade);
		 gradeDetailsDto.setDepartement(departement);
		 gradeDetailsDto.setPoste(poste);
		return gradeDetailsDto;
			
		}

	public Long getId() {
		return idGrade;
	}

	public void setId(Long id) {
		this.idGrade = id;
	}

	public Set<Collaborateur> getCollaborateurs() {
		return collaborateurs;
	}

	public void setCollaborateurs(Set<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}


}
