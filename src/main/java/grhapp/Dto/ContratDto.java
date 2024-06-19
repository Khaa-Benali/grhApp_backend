package grhapp.Dto;

import java.util.Date;
import java.util.List;

public class ContratDto {
	 private Date dateDebut;
	    private Date dateFin;
	    private Double baseSalary;
	    private String typeContrat;
	    private List<Long> documentIds;
		public Date getDateDebut() {
			return dateDebut;
		}
		public void setDateDebut(Date dateDebut) {
			this.dateDebut = dateDebut;
		}
		public Date getDateFin() {
			return dateFin;
		}
		public void setDateFin(Date dateFin) {
			this.dateFin = dateFin;
		}
		public Double getBaseSalary() {
			return baseSalary;
		}
		public void setBaseSalary(Double baseSalary) {
			this.baseSalary = baseSalary;
		}
		public String getTypeContrat() {
			return typeContrat;
		}
		public void setTypeContrat(String typeContrat) {
			this.typeContrat = typeContrat;
		}
		public List<Long> getDocumentIds() {
			return documentIds;
		}
		public void setDocumentIds(List<Long> documentIds) {
			this.documentIds = documentIds;
		}
	    

}
