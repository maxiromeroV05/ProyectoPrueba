package org.example.eduechinnovators.repository;

import org.example.eduechinnovators.jparepository.JpaInscripcionRepository;
import org.example.eduechinnovators.model.Inscripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InscripcionRepository {

    @Autowired
    private JpaInscripcionRepository jpaRepository;

    public List<Inscripcion> findAll() {
        return jpaRepository.findAll();
    }

    public Optional<Inscripcion> findById(int id) {
        return jpaRepository.findById(id);
    }

    public Inscripcion save(Inscripcion inscripcion) {
        return jpaRepository.save(inscripcion);
    }

    public void deleteById(int id) {
        jpaRepository.deleteById(id);
    }
}

