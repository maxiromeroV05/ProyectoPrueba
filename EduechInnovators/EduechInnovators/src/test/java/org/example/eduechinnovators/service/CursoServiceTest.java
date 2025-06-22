package org.example.eduechinnovators.service;

import org.example.eduechinnovators.jparepository.JpaCursoRepository;
import org.example.eduechinnovators.model.Curso;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CursoServiceTest {

    @Mock
    private JpaCursoRepository cursoRepository;

    @InjectMocks
    private CursoService cursoService;

    private Curso curso;

    @BeforeEach
    void setUp() {
        curso = new Curso();
        curso.setId(1);
        curso.setNombre("Java");
        curso.setGestion("2025");
        curso.setInstructores("Profesor X");
        curso.setEvaluar("S");
    }

    @Test
    void guardarCurso_debeGuardarYRetornarCurso() {
        when(cursoRepository.save(curso)).thenReturn(curso);

        Curso resultado = cursoService.guardarCurso(curso);

        assertNotNull(resultado);
        assertEquals("Java", resultado.getNombre());
        verify(cursoRepository).save(curso);
    }

    @Test
    void buscarCursos_debeRetornarListaDeCursos() {
        when(cursoRepository.findAll()).thenReturn(List.of(curso));

        List<Curso> resultado = cursoService.buscarCursos();

        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.size());
        verify(cursoRepository).findAll();
    }

    @Test
    void buscarCursoId_cuandoExiste_debeRetornarCurso() {
        when(cursoRepository.findById(1)).thenReturn(Optional.of(curso));

        Curso resultado = cursoService.buscarCursoId(1);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        verify(cursoRepository).findById(1);
    }

    @Test
    void buscarCursoId_cuandoNoExiste_debeRetornarNull() {
        when(cursoRepository.findById(99)).thenReturn(Optional.empty());

        Curso resultado = cursoService.buscarCursoId(99);

        assertNull(resultado);
        verify(cursoRepository).findById(99);
    }

    @Test
    void editarCurso_cuandoExiste_debeActualizarYRetornarCurso() {
        Curso cursoEditado = new Curso();
        cursoEditado.setNombre("Python");
        cursoEditado.setGestion("2026");
        cursoEditado.setInstructores("Profesor Y");
        cursoEditado.setEvaluar("N");

        when(cursoRepository.findById(1)).thenReturn(Optional.of(curso));
        when(cursoRepository.save(any(Curso.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Curso resultado = cursoService.editarCurso(1, cursoEditado);

        assertNotNull(resultado);
        assertEquals("Python", resultado.getNombre());
        assertEquals("2026", resultado.getGestion());
        assertEquals("Profesor Y", resultado.getInstructores());
        assertEquals("N", resultado.getEvaluar());
        verify(cursoRepository).findById(1);
        verify(cursoRepository).save(resultado);
    }

    @Test
    void editarCurso_cuandoNoExiste_debeRetornarNull() {
        Curso cursoEditado = new Curso();
        when(cursoRepository.findById(2)).thenReturn(Optional.empty());

        Curso resultado = cursoService.editarCurso(2, cursoEditado);

        assertNull(resultado);
        verify(cursoRepository).findById(2);
        verify(cursoRepository, never()).save(any());
    }

    @Test
    void eliminarCurso_debeLlamarDeleteById() {
        doNothing().when(cursoRepository).deleteById(1);

        String resultado = cursoService.eliminarCurso(1);

        assertEquals("Curso eliminado", resultado);
        verify(cursoRepository).deleteById(1);
    }
}
