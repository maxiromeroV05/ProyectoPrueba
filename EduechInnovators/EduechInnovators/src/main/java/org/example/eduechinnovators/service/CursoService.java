package org.example.eduechinnovators.service;

import org.example.eduechinnovators.model.Curso;
import org.example.eduechinnovators.jparepository.JpaCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private JpaCursoRepository cursoRepository;

    public Curso guardarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> buscarCursos() {
        return cursoRepository.findAll();
    }

    public Curso buscarCursoId(int id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public Curso editarCurso(int id, Curso curso) {
        Curso cursoExistente = buscarCursoId(id);
        if (cursoExistente != null) {
            cursoExistente.setNombre(curso.getNombre());
            cursoExistente.setGestion(curso.getGestion());
            cursoExistente.setInstructores(curso.getInstructores());
            cursoExistente.setEvaluar(curso.getEvaluar());
            return cursoRepository.save(cursoExistente);
        }
        return null;
    }

    public String eliminarCurso(int id) {
        cursoRepository.deleteById(id);
        return "Curso eliminado";
    }
}

