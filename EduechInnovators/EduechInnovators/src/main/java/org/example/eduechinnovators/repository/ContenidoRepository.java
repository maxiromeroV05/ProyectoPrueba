package org.example.eduechinnovators.repository;

import org.example.eduechinnovators.model.Contenido;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContenidoRepository {
    private List<Contenido> contenidos = new ArrayList<>();
    private int idCounter = 1;

    // Obtener todos los contenidos
    public List<Contenido> obtenerContenidos() {
        return contenidos;
    }

    // Guardar un nuevo contenido
    public Contenido guardarContenido(Contenido contenido) {
        contenido.setId(idCounter++);
        contenidos.add(contenido);
        return contenido;
    }

    // Buscar un contenido por ID
    public Contenido buscarContenido(int id) {
        return contenidos.stream()
                .filter(contenido -> contenido.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Actualizar un contenido
    public Contenido actualizarContenido(Contenido contenidoActualizado) {
        Contenido contenidoExistente = buscarContenido(contenidoActualizado.getId());
        if (contenidoExistente != null) {
            contenidoActualizado.setId(contenidoExistente.getId());
            contenidoExistente.setMateria(contenidoActualizado.getMateria());
            contenidoExistente.setEvaluaciones(contenidoActualizado.getEvaluaciones());
            contenidoExistente.setProgreso(contenidoActualizado.getProgreso());
            contenidoExistente.setForos(contenidoActualizado.getForos());

        }
        return contenidoExistente;
    }

    // Eliminar un contenido por ID
    public void eliminar(int id) {
        contenidos.removeIf(contenido -> contenido.getId() == id);
    }
}

