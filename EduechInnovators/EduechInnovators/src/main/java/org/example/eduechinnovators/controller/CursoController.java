package org.example.eduechinnovators.controller;



import org.example.eduechinnovators.model.Curso;
import org.example.eduechinnovators.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public Curso crearCurso(@RequestBody Curso curso) {
        return cursoService.guardarCurso(curso);
    }

    @GetMapping
    public List<Curso> obtenerTodosLosCursos() {
        return cursoService.buscarCursos();
    }

    @GetMapping("/{id}")
    public Curso obtenerCursoPorId(@PathVariable int id) {
        return cursoService.buscarCursoId(id);
    }

    @PutMapping("/{id}")
    public Curso editarCurso(@PathVariable int id, @RequestBody Curso curso) {
        return cursoService.editarCurso(id, curso);
    }

    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable int id) {
        cursoService.eliminarCurso(id);
    }
}
