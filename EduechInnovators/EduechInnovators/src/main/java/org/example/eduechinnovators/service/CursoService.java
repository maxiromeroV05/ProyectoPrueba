package org.example.eduechinnovators.service;

import org.example.eduechinnovators.model.Curso;
import org.example.eduechinnovators.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
   @Autowired
   private CursoRepository cursoRepository;

    public List<Curso> buscarCursos() {
        return cursoRepository.obtenerCursos();
    }

    public Curso guardarCurso(Curso curso) {
        return cursoRepository.guardarCurso(curso);

    }

    public Curso buscarCursoId(int id) {
        return cursoRepository.buscarCurso(id);
    }

    public Curso editarCurso(int id ,Curso curso) {
        return cursoRepository.actualizarCurso(curso);
    }

    public String eliminarCurso(int id) {
        cursoRepository.eliminar(id);
        return "Curso eliminado";

    }
}
