package org.example.eduechinnovators.service;

import org.example.eduechinnovators.jparepository.JpaContenidoRepository;
import org.example.eduechinnovators.model.Contenido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContenidoService {

    @Autowired
    private JpaContenidoRepository repository;

    public Contenido guardar(Contenido contenido) {
        return repository.save(contenido);
    }

    public List<Contenido> listar() {
        return repository.findAll();
    }

    public Contenido buscarPorId(int idContenido) {
        return repository.findById(idContenido).orElse(null);
    }

    public Contenido editar(int idContenido, Contenido nuevo) {
        Contenido existente = buscarPorId(idContenido);
        if (existente != null) {
            existente.setMateria(nuevo.getMateria());
            existente.setEvaluaciones(nuevo.getEvaluaciones());
            existente.setProgreso(nuevo.getProgreso());
            existente.setForos(nuevo.getForos());
            return repository.save(existente);
        }
        return null;
    }

    public String eliminar(int idContenido) {
        repository.deleteById(idContenido);
        return "Contenido eliminado con éxito";
    }
}


