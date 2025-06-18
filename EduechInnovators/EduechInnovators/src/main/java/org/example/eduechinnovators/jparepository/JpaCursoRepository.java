package org.example.eduechinnovators.jparepository;

import org.example.eduechinnovators.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCursoRepository extends JpaRepository<Curso, Integer> {

}
