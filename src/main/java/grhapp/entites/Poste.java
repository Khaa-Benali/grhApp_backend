package grhapp.entites;

import java.util.Set;

import grhapp.Dto.PosteDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Postes")
@Data
@AllArgsConstructor
@Getter
@Setter
public class Poste {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPoste;
	@Column(name = "nom" , nullable = false)
	private String nom;
	@OneToMany(mappedBy = "poste", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Grade> grades;
	public Long getId() {
		return idPoste;
	}
	public void setId(Long id) {
		this.idPoste = id;
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
	
	public PosteDto  getPosteDto() {
		PosteDto posteDto = new PosteDto();
		posteDto.setNom(nom);
		posteDto.setPosteid(idPoste);
		return posteDto;
		
	}
	}
	
