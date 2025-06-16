package org.example.eduechinnovators.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.eduechinnovators.model.Soporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class SoporteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Usar JpaRepository para las operaciones básicas de CRUD
    @Autowired
    private JpaSoporteRepository jpaSoporteRepository;

    // Obtener todos los soportes
    // Obtener todos los soportes
    public List<Soporte> findAll() {
        return jpaSoporteRepository.findAll();
    }

    // Buscar soporte por ID
    public Optional<Soporte> findById(int id) {
        return jpaSoporteRepository.findById(id);
    }

    // Guardar soporte
    public Soporte save(Soporte soporte) {
        return jpaSoporteRepository.save(soporte);
    }

    // Eliminar soporte por ID
    public void deleteById(int id) {
        jpaSoporteRepository.deleteById(id);
    }

}

