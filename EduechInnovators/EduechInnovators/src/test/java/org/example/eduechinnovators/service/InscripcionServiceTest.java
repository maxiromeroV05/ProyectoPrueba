package org.example.eduechinnovators.service;

import org.example.eduechinnovators.model.Inscripcion;
import org.example.eduechinnovators.repository.InscripcionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InscripcionServiceTest {

    @Mock
    private InscripcionRepository inscripcionRepository;

    @InjectMocks
    private InscripcionService inscripcionService;

    private Inscripcion inscripcionEjemplo;

    @BeforeEach
    void inicializar() {
        MockitoAnnotations.openMocks(this);
        inscripcionEjemplo = new Inscripcion(1, new Date(), 101, 202);
    }

    @Test
    void guardarInscripcion() {
        when(inscripcionRepository.save(inscripcionEjemplo)).thenReturn(inscripcionEjemplo);

        Inscripcion resultado = inscripcionService.guardarInscripcion(inscripcionEjemplo);

        assertNotNull(resultado);
        assertEquals(inscripcionEjemplo, resultado);
        verify(inscripcionRepository, times(1)).save(inscripcionEjemplo);
    }

    @Test
    void obtenerTodas() {
        List<Inscripcion> lista = Arrays.asList(inscripcionEjemplo);
        when(inscripcionRepository.findAll()).thenReturn(lista);

        List<Inscripcion> resultado = inscripcionService.obtenerTodas();

        assertEquals(1, resultado.size());
        assertEquals(inscripcionEjemplo, resultado.get(0));
        verify(inscripcionRepository, times(1)).findAll();
    }

    @Test
    void obtenerPorId() {
        when(inscripcionRepository.findById(1)).thenReturn(Optional.of(inscripcionEjemplo));

        Inscripcion resultado = inscripcionService.obtenerPorId(1);

        assertNotNull(resultado);
        assertEquals(inscripcionEjemplo, resultado);
        verify(inscripcionRepository, times(1)).findById(1);
    }

    @Test
    void obtenerPorId_() {
        when(inscripcionRepository.findById(99)).thenReturn(Optional.empty());

        Inscripcion resultado = inscripcionService.obtenerPorId(99);

        assertNull(resultado);
        verify(inscripcionRepository, times(1)).findById(99);
    }

    @Test
    void actualizarInscripcion_() {
        Inscripcion inscripcionActualizada = new Inscripcion(1, new Date(), 111, 222);

        when(inscripcionRepository.findById(1)).thenReturn(Optional.of(inscripcionEjemplo));
        when(inscripcionRepository.save(any(Inscripcion.class))).thenReturn(inscripcionActualizada);

        Inscripcion resultado = inscripcionService.actualizarInscripcion(1, inscripcionActualizada);

        assertNotNull(resultado);
        assertEquals(inscripcionActualizada.getIdC(), resultado.getIdC());
        assertEquals(inscripcionActualizada.getIdU(), resultado.getIdU());
        verify(inscripcionRepository, times(1)).findById(1);
        verify(inscripcionRepository, times(1)).save(any(Inscripcion.class));
    }

    @Test
    void actualizarInscripcion() {
        Inscripcion inscripcionActualizada = new Inscripcion(99, new Date(), 111, 222);

        when(inscripcionRepository.findById(99)).thenReturn(Optional.empty());

        Inscripcion resultado = inscripcionService.actualizarInscripcion(99, inscripcionActualizada);

        assertNull(resultado);
        verify(inscripcionRepository, times(1)).findById(99);
        verify(inscripcionRepository, never()).save(any());
    }

    @Test
    void eliminarInscripcion() {
        doNothing().when(inscripcionRepository).deleteById(1);

        inscripcionService.eliminarInscripcion(1);

        verify(inscripcionRepository, times(1)).deleteById(1);
    }
}

