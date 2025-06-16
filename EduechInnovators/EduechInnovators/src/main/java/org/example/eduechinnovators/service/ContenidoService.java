package org.example.eduechinnovators.service;

import org.example.eduechinnovators.model.Contenido;
import org.example.eduechinnovators.repository.JpaContenidoRepository;
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

    public Contenido buscarPorId(int id) {
        return repository.findById(id).orElse(null);
    }

    public Contenido editar(int id, Contenido nuevo) {
        Contenido existente = buscarPorId(id);
        if (existente != null) {
            existente.setMateria(nuevo.getMateria());
            existente.setEvaluaciones(nuevo.getEvaluaciones());
            existente.setProgreso(nuevo.getProgreso());
            existente.setForos(nuevo.getForos());
            return repository.save(existente);
        }
        return null;
    }

    public String eliminar(int id) {
        repository.deleteById(id);
        return "Se eliminó con éxito";
    }
}

