package grhapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import grhapp.entites.Collaborateur;

public interface CollaborateurRepository  extends JpaRepository<Collaborateur, Long> {

	Collaborateur findByCin(int cin);

}
