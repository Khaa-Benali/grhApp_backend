package grhapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import grhapp.entites.Poste;

@Repository
public interface PosteRepository extends JpaRepository<Poste, Long> {
   
}
