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

    public List<Curso> getCursos() {
        return cursoRepository.obtenerCursos();
    }

    public Curso saveCurso(Curso curso) {
        return cursoRepository.guardarCurso(curso);

    }

    public Curso getCursoId(int id) {
        return cursoRepository.buscarCurso(id);
    }

    public Curso updateCurso(int id ,Curso curso) {
        return cursoRepository.actualizarCurso(curso);
    }

    public String deleteCurso(int id) {
        cursoRepository.eliminar(id);
        return "Curso eliminado";

    }
}
