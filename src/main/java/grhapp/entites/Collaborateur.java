package grhapp.entites;

import java.util.Date;

import grhapp.Dto.CollaborateurDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name= "Collaborateur")
public class Collaborateur {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
  	private Long id;
	private int cin;
	
    @NotBlank(message = "Le nom complet est obligatoire.")
	private String nomComplet;
    
	@Email(message = "L'e-mail doit être dans un format valide.")
    private String email;
	
	@Pattern(regexp = "\\d{13}", message = "Le numéro du compte doit contenir 13 chiffres.")
    private String numCompte;
	
	@Pattern(regexp = "\\d{15}", message = "Le numéro de la sécurité sociale doit contenir 15 chiffres.")
    private String numSecurite;
	
	@Past(message = "La date de naissance doit être dans le passé.")
    @Temporal(TemporalType.DATE)
    private Date dateNaiss;
	
	@Pattern(regexp = "\\d{8}", message = "Le numéro de téléphone doit contenir 10 chiffres.")
    private String tel;
	
	@Column(name="adresse")
    private String adresse;
	
    private String commentaire;
    
    @OneToOne
    @JoinColumn(name = "contrat_id") 
    private Contrat contrat;
    
    @ManyToOne
	 @JoinColumn(name = "grade_id", nullable = false)
     private Grade grade;


    @OneToOne
    @JoinColumn(name = "qualification_id") 
    private Qualification qualification;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getCin() {
		return cin;
	}


	public void setCin(int cin) {
		this.cin = cin;
	}


	public String getNomComplet() {
		return nomComplet;
	}


	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNumCompte() {
		return numCompte;
	}


	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}


	public String getNumSecurite() {
		return numSecurite;
	}


	public void setNumSecurite(String numSecurite) {
		this.numSecurite = numSecurite;
	}


	public Date getDateNaiss() {
		return dateNaiss;
	}


	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public Contrat getContrat() {
		return contrat;
	}


	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}


	public Grade getGrade() {
		return grade;
	}


	public void setGrade(Grade grade) {
		this.grade = grade;
	}


	public Qualification getQualification() {
		return qualification;
	}


	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}
	  public CollaborateurDto getCollaborateurDto() {
		     Date dated= this.contrat.getDateD();
		     String poste= this.getGrade().getPoste().getNom();
		     String typeContrat= this.contrat.getTypeContrat() ;
	    	CollaborateurDto collaborateurdto = new CollaborateurDto(id,nomComplet,poste,typeContrat,dated);
	    	return collaborateurdto;
	    	
	    }
}