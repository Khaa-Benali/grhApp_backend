package grhapp.entites;

import grhapp.Dto.QualificationDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="qualifications")
public class Qualification {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idQualification;
	 private String natureEtude;
    private String niveauEtudes;
	 private String certification;
	 private int anneeExperience;
	 
	 @OneToOne(mappedBy = "qualification")
	    private Collaborateur collaborateur;

	public Long getId() {
		return idQualification;
	}

	public void setId(Long id) {
		this.idQualification = id;
	}

	public String getNatureEtude() {
		return natureEtude;
	}

	public void setNatureEtude(String natureEtude) {
		this.natureEtude = natureEtude;
	}

	public String getNiveauEtudes() {
		return niveauEtudes;
	}

	public void setNiveauEtudes(String niveauEtudes) {
		this.niveauEtudes = niveauEtudes;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public int getAnneeExperience() {
		return anneeExperience;
	}

	public void setAnneeExperience(int anneeExperience) {
		this.anneeExperience = anneeExperience;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}
	 
	public QualificationDto getQualificationDto() {
        QualificationDto qualificationDto = new QualificationDto();
        qualificationDto.setIdQualification(this.idQualification);
        qualificationDto.setNatureEtude(this.natureEtude);
        qualificationDto.setNiveauEtudes(this.niveauEtudes);
        qualificationDto.setCertification(this.certification);
        qualificationDto.setAnneeExperience(this.anneeExperience);
		return qualificationDto;
	}
	
}