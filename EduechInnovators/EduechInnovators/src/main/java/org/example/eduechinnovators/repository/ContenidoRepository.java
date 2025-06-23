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
        contenido.setIdC(idCounter++);
        contenidos.add(contenido);
        return contenido;
    }

    public Contenido buscarContenido(int id) {
        return contenidos.stream()
                .filter(contenido -> contenido.getIdC() == id)
                .findFirst()
                .orElse(null);
    }

    public Contenido actualizarContenido(Contenido contenidoActualizado) {
        Contenido existente = buscarContenido(contenidoActualizado.getIdC());
        if (existente != null) {
            existente.setMateria(contenidoActualizado.getMateria());
            existente.setEvaluaciones(contenidoActualizado.getEvaluaciones());
            existente.setProgreso(contenidoActualizado.getProgreso());
            existente.setForos(contenidoActualizado.getForos());
        }
        return existente;
    }

    public void eliminar(int id) {
        contenidos.removeIf(contenido -> contenido.getIdC() == id);
    }
}

