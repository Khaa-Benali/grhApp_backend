package grhapp.services.Collaborateur;

import java.util.List;
import java.util.Optional;

import grhapp.Dto.CollaborateurDto;
import grhapp.entites.Collaborateur;

public interface CollaborateurService {
    List<CollaborateurDto> getAllCollaborateurs();
    Optional<Collaborateur> getCollaborateurById(Long id);
    Collaborateur ajouterCollaborateur(Collaborateur collaborateur);
    void deleteCollaborateur(Long id);
    double calculMasseSalariale();


}
