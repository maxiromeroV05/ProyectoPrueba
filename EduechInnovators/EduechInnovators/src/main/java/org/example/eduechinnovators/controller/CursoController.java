package org.example.eduechinnovators.controller;



import org.example.eduechinnovators.model.Curso;
import org.example.eduechinnovators.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    // Crear un nuevo curso
    @PostMapping
    public Curso crearCurso(@RequestBody Curso curso) {
        return cursoService.saveCurso(curso);
    }

    // Obtener todos los cursos
    @GetMapping
    public List<Curso> obtenerTodosLosCursos() {
        return cursoService.getCursos();
    }

    // Obtener un curso por ID
    @GetMapping("/{id}")
    public Curso obtenerCursoPorId(@PathVariable int id) {
        return cursoService.getCursoId(id);
    }

    // Actualizar un curso existente
    @PutMapping("/{id}")
    public Curso actualizarCurso(@PathVariable int id, @RequestBody Curso curso) {
        return cursoService.updateCurso(id, curso);
    }

    // Eliminar un curso
    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable int id) {
        cursoService.deleteCurso(id);
    }
}
