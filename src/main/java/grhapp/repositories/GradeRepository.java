package grhapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import grhapp.entites.Grade;

public interface GradeRepository  extends JpaRepository<Grade, Long>{

}
