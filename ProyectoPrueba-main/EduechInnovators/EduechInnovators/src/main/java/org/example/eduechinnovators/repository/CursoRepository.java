package org.example.eduechinnovators.repository;

import org.example.eduechinnovators.model.Curso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CursoRepository {
    private List<Curso> cursos = new ArrayList<>();
    private int idCounter = 1;

    // Obtener todos los cursos
    public List<Curso> obtenerCursos() {
        return cursos;
    }

    // Guardar un nuevo curso
    public Curso guardarCurso(Curso curso) {
        curso.setId(idCounter++);
        cursos.add(curso);
        return curso;
    }

    // Buscar un curso por ID
    public Curso buscarCurso(int id) {
        return cursos.stream()
                .filter(curso -> curso.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Actualizar un curso
    public Curso actualizarCurso(Curso cursoActualizado) {
        Curso cursoExistente = buscarCurso(cursoActualizado.getId());
        if (cursoExistente != null) {
            cursoExistente.setNombre(cursoActualizado.getNombre());
            cursoExistente.setGestion(cursoActualizado.getGestion());
            cursoExistente.setInstructores(cursoActualizado.getInstructores());
            cursoExistente.setEvaluar(cursoActualizado.isEvaluar());
        }
        return cursoExistente;
    }

    // Eliminar un curso por ID
    public void eliminar(int id) {
        cursos.removeIf(curso -> curso.getId() == id);
    }
}
