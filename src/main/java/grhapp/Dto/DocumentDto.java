package grhapp.Dto;

import grhapp.entites.Contrat;

public class DocumentDto {
	private Long idDoc;
	private String nom;
	private String type;
	private boolean isMandatory;
    private Contrat contrat;
	public Long getIdDoc() {
		return idDoc;
	}
	public void setIdDoc(Long idDoc) {
		this.idDoc = idDoc;
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
    


}
