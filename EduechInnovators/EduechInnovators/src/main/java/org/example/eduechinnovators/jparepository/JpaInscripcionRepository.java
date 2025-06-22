package org.example.eduechinnovators.jparepository;

import org.example.eduechinnovators.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaInscripcionRepository extends JpaRepository<Inscripcion, Integer> {

}