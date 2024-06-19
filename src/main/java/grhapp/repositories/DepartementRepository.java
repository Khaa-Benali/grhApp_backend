package grhapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import grhapp.entites.Departement;

public interface DepartementRepository  extends JpaRepository<Departement, Long> {

}
