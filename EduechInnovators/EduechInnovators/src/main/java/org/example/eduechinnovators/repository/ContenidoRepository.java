package org.example.eduechinnovators.repository;

import org.example.eduechinnovators.model.Contenido;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContenidoRepository {
    private List<Contenido> contenidos = new ArrayList<>();
    private int idCounter = 1;

    public List<Contenido> obtenerContenidos() {
        return contenidos;
    }

    public Contenido guardarContenido(Contenido contenido) {
        contenido.setId(idCounter++);
        contenidos.add(contenido);
        return contenido;
    }

    public Contenido buscarContenido(int id) {
        return contenidos.stream()
                .filter(contenido -> contenido.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Contenido actualizarContenido(Contenido contenidoActualizado) {
        Contenido existente = buscarContenido(contenidoActualizado.getId());
        if (existente != null) {
            existente.setMateria(contenidoActualizado.getMateria());
            existente.setEvaluaciones(contenidoActualizado.getEvaluaciones());
            existente.setProgreso(contenidoActualizado.getProgreso());
            existente.setForos(contenidoActualizado.getForos());
        }
        return existente;
    }

    public void eliminar(int id) {
        contenidos.removeIf(contenido -> contenido.getId() == id);
    }
}

