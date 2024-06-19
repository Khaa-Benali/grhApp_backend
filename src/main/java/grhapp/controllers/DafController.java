package grhapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grhapp.Dto.CollaborateurDto;
import grhapp.services.Collaborateur.CollaborateurService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/daf")
public class DafController {


	 @Autowired
	  private CollaborateurService collaborateurService;
	 
	 @PreAuthorize("hasRole('DAF')")
	 @GetMapping("/collaborateurs")
	 public List<CollaborateurDto> getAllCollaborateurs() {
	  
			return collaborateurService.getAllCollaborateurs();
	    }
 

	 @PreAuthorize("hasRole('DAF')")
	 @GetMapping("/masse-salariale")
	    public ResponseEntity<Double> getMasseSalariale() {
	        double masseSalariale = collaborateurService.calculMasseSalariale();
	        return ResponseEntity.ok(masseSalariale);
	    }
}
