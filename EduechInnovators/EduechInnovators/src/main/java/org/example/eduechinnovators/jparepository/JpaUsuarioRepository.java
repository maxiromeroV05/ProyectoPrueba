package org.example.eduechinnovators.jparepository;

import org.example.eduechinnovators.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
