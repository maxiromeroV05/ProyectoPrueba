package org.example.eduechinnovators.repository;

import org.example.eduechinnovators.model.Curso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CursoRepositoryTest {

    private CursoRepository repository;

    @BeforeEach
    void setUp() {
        repository = new CursoRepository();
    }

    @Test
    void guardarCurso() {
        Curso curso = new Curso(0, "Java", "2025", "Prof. A", "S");
        Curso guardado = repository.guardarCurso(curso);

        assertNotNull(guardado);
        assertEquals(1, guardado.getIdCN());
        assertEquals("Java", guardado.getNombre());
    }

    @Test
    void obtenerCursos() {
        repository.guardarCurso(new Curso(0, "Python", "2025", "Prof. B", "N"));

        List<Curso> lista = repository.obtenerCursos();

        assertEquals(1, lista.size());
        assertEquals("Python", lista.get(0).getNombre());
    }

    @Test
    void buscarCurso_existente() {
        Curso guardado = repository.guardarCurso(new Curso(0, "SQL", "2025", "Prof. C", "S"));

        Curso resultado = repository.buscarCurso(guardado.getIdCN());

        assertNotNull(resultado);
        assertEquals("SQL", resultado.getNombre());
    }

    @Test
    void buscarCurso_noExistente() {
        Curso resultado = repository.buscarCurso(999);

        assertNull(resultado);
    }

    @Test
    void actualizarCurso_existente() {
        Curso guardado = repository.guardarCurso(new Curso(0, "HTML", "2024", "Prof. D", "N"));

        Curso actualizado = new Curso(guardado.getIdCN(), "HTML5", "2025", "Prof. E", "S");

        Curso resultado = repository.actualizarCurso(actualizado);

        assertNotNull(resultado);
        assertEquals("HTML5", resultado.getNombre());
        assertEquals("2025", resultado.getGestion());
        assertEquals("Prof. E", resultado.getInstructores());
        assertEquals("S", resultado.getEvaluar());
    }

    @Test
    void actualizarCurso_noExistente() {
        Curso noExistente = new Curso(999, "CSS", "2023", "Prof. F", "N");

        Curso resultado = repository.actualizarCurso(noExistente);

        assertNull(resultado);
    }

    @Test
    void eliminarCurso() {
        Curso guardado = repository.guardarCurso(new Curso(0, "JavaScript", "2025", "Prof. G", "S"));

        repository.eliminar(guardado.getIdCN());

        assertTrue(repository.obtenerCursos().isEmpty());
    }
}

