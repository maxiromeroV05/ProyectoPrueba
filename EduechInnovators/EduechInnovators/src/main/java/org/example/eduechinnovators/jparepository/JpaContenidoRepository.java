package org.example.eduechinnovators.jparepository;

import org.example.eduechinnovators.model.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaContenidoRepository extends JpaRepository<Contenido, Integer> {
}
