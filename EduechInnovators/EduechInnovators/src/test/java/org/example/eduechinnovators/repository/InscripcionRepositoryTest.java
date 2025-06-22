package org.example.eduechinnovators.repository;

import org.example.eduechinnovators.jparepository.JpaInscripcionRepository;
import org.example.eduechinnovators.model.Inscripcion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InscripcionRepositoryTest {

    @Mock
    private JpaInscripcionRepository jpaRepository;

    @InjectMocks
    private InscripcionRepository inscripcionRepository;

    private Inscripcion inscripcionEjemplo;

    @BeforeEach
    void inicializar() {
        MockitoAnnotations.openMocks(this);
        inscripcionEjemplo = new Inscripcion(1, new Date(), 101, 202);
    }

    @Test
    void listarTodasLasInscripciones() {
        List<Inscripcion> lista = Arrays.asList(inscripcionEjemplo);
        when(jpaRepository.findAll()).thenReturn(lista);

        List<Inscripcion> resultado = inscripcionRepository.findAll();

        assertEquals(1, resultado.size());
        assertEquals(inscripcionEjemplo, resultado.get(0));
        verify(jpaRepository, times(1)).findAll();
    }

    @Test
    void buscarPorId() {
        when(jpaRepository.findById(1)).thenReturn(Optional.of(inscripcionEjemplo));

        Optional<Inscripcion> resultado = inscripcionRepository.findById(1);

        assertTrue(resultado.isPresent());
        assertEquals(inscripcionEjemplo, resultado.get());
        verify(jpaRepository, times(1)).findById(1);
    }

    @Test
    void guardarInscripcion() {
        when(jpaRepository.save(inscripcionEjemplo)).thenReturn(inscripcionEjemplo);

        Inscripcion resultado = inscripcionRepository.save(inscripcionEjemplo);

        assertNotNull(resultado);
        assertEquals(inscripcionEjemplo, resultado);
        verify(jpaRepository, times(1)).save(inscripcionEjemplo);
    }

    @Test
    void eliminarPorId() {
        doNothing().when(jpaRepository).deleteById(1);

        inscripcionRepository.deleteById(1);

        verify(jpaRepository, times(1)).deleteById(1);
    }
}


