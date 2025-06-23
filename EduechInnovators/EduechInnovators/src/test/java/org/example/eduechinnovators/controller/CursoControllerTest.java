package org.example.eduechinnovators.controller;

import org.example.eduechinnovators.model.Curso;
import org.example.eduechinnovators.service.CursoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CursoControllerTest {

    @Mock
    private CursoService cursoService;

    @InjectMocks
    private CursoController cursoController;

    @Test
    void crearCurso() {
        Curso curso = new Curso(0, "Java", "2025", "Instructor A", "S");
        Curso creado = new Curso(1, "Java", "2025", "Instructor A", "S");

        when(cursoService.guardarCurso(curso)).thenReturn(creado);

        Curso resultado = cursoController.crearCurso(curso);

        assertNotNull(resultado);
        assertEquals(1, resultado.getIdCN());
        assertEquals("Java", resultado.getNombre());
    }

    @Test
    void obtenerTodosLosCursos() {
        Curso curso = new Curso(1, "Python", "2025", "Instructor B", "N");
        when(cursoService.buscarCursos()).thenReturn(List.of(curso));

        List<Curso> resultado = cursoController.obtenerTodosLosCursos();

        assertEquals(1, resultado.size());
        assertEquals("Python", resultado.get(0).getNombre());
    }

    @Test
    void obtenerCursoPorId() {
        Curso curso = new Curso(1, "SQL", "2025", "Instructor C", "S");
        when(cursoService.buscarCursoId(1)).thenReturn(curso);

        Curso resultado = cursoController.obtenerCursoPorId(1);

        assertNotNull(resultado);
        assertEquals("SQL", resultado.getNombre());
    }

    @Test
    void editarCurso() {
        int id = 1;
        Curso nuevo = new Curso(0, "JavaScript", "2025", "Instructor D", "S");
        Curso editado = new Curso(id, "JavaScript", "2025", "Instructor D", "S");

        when(cursoService.editarCurso(id, nuevo)).thenReturn(editado);

        Curso resultado = cursoController.editarCurso(id, nuevo);

        assertNotNull(resultado);
        assertEquals(id, resultado.getIdCN());
        assertEquals("JavaScript", resultado.getNombre());
    }

    @Test
    void eliminarCurso() {
        int id = 2;

        cursoController.eliminarCurso(id);
        verify(cursoService, times(1)).eliminarCurso(id);
    }
}

