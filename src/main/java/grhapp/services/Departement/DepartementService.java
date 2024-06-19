package grhapp.services.Departement;

import java.util.List;
import java.util.Optional;

import grhapp.entites.Departement;

public interface DepartementService {

    List<Departement> getAllDepartements();
    Optional<Departement> getDepartementById(Long id);
    Departement saveDepartement(Departement departement);
    void deleteDepartement(Long id);
}
