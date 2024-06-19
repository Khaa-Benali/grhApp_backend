package grhapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grhapp.entites.Collaborateur;
import grhapp.services.Collaborateur.CollaborateurService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/rh")
public class RhController {


	 @Autowired
	    private CollaborateurService collaborateurService;
	 @PreAuthorize("hasRole('RH')")
	    @PostMapping("/ajouterCollab")
	 public ResponseEntity<?> ajouterCollaborateur(@RequestBody Collaborateur collaborateur) {
	        try {
	            Collaborateur savedCollaborateur = collaborateurService.ajouterCollaborateur(collaborateur);
	            return ResponseEntity.ok(savedCollaborateur);
	        } catch (IllegalArgumentException ex) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body("Erreur : Le collaborateur avec le numéro de CIN " + collaborateur.getCin() + " existe déjà.");
	        }
	    }
}
