package grhapp.Dto;

import java.util.Date;

import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
import java.time.ZoneId;


public class CollaborateurDto {
    private Long idCollaborateur;
    private String nomComplet;
    private String poste;
    private String typeContrat;
     private long anciennete;

    public CollaborateurDto(Long idCollaborateur, String nomComplet, String poste, String typeContrat,Date dateEmbauche) {
        this.idCollaborateur = idCollaborateur;
        this.nomComplet = nomComplet;
        this.poste = poste;
        this.typeContrat = typeContrat;
       this.anciennete = calculerAnciennete(dateEmbauche);
    }
    // Getters and setters

    public Long getIdCollaborateur() {
        return idCollaborateur;
    }

    public void setIdCollaborateur(Long idCollaborateur) {
        this.idCollaborateur = idCollaborateur;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

   public long getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(Long anciennete) {
        this.anciennete = anciennete;
    }
    private long calculerAnciennete(Date dateEmbauche) {
        // Conversion de la Date en Instant
        Instant instantEmbauche = dateEmbauche.toInstant();
     // Création d'un ZonedDateTime à partir de l'Instant avec le fuseau horaire par défaut
        ZonedDateTime zonedDateTimeEmbauche = instantEmbauche.atZone(ZoneId.systemDefault());


        // Obtention de la date actuelle sous forme de ZonedDateTime
        ZonedDateTime now = ZonedDateTime.now();

        // Calcul de la différence entre les deux dates
        Duration duration = Duration.between(zonedDateTimeEmbauche, now);

        // Retourner l'ancienneté en secondes
        return duration.getSeconds();
    }
    
}
