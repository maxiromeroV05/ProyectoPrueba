package org.example.eduechinnovators.repository;

import org.example.eduechinnovators.model.Curso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CursoRepository {
    private List<Curso> cursos = new ArrayList<>();
    private int idCounter = 1;

    public List<Curso> obtenerCursos() {
        return cursos;
    }

    public Curso guardarCurso(Curso curso) {
        curso.setId(idCounter++);
        cursos.add(curso);
        return curso;
    }

    public Curso buscarCurso(int id) {
        return cursos.stream()
                .filter(curso -> curso.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Curso actualizarCurso(Curso cursoActualizado) {
        Curso cursoExistente = buscarCurso(cursoActualizado.getId());
        if (cursoExistente != null) {
            cursoExistente.setNombre(cursoActualizado.getNombre());
            cursoExistente.setGestion(cursoActualizado.getGestion());
            cursoExistente.setInstructores(cursoActualizado.getInstructores());
            cursoExistente.setEvaluar(cursoActualizado.getEvaluar());
        }
        return cursoExistente;
    }

    public void eliminar(int id) {
        cursos.removeIf(curso -> curso.getId() == id);
    }
}
