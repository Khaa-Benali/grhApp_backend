package grhapp.Dto;

public class QualificationDto {
	    private Long idQualification;
	    private String natureEtude;
	    private String niveauEtudes;
	    private String certification;
	    private int anneeExperience;
		public Long getIdQualification() {
			return idQualification;
		}
		public void setIdQualification(Long idQualification) {
			this.idQualification = idQualification;
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
	    

}
