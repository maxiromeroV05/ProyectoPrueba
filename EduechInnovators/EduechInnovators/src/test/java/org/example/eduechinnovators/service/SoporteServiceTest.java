package org.example.eduechinnovators.service;

import org.example.eduechinnovators.jparepository.JpaSoporteRepository;
import org.example.eduechinnovators.model.Soporte;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SoporteServiceTest {

    @Mock
    private JpaSoporteRepository soporteRepository;

    @InjectMocks
    private SoporteService soporteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarTodosLosSoportes_debeRetornarLista() {
        List<Soporte> lista = Arrays.asList(
                new Soporte(1, 101, "Mensaje 1", "Abierto"),
                new Soporte(2, 102, "Mensaje 2", "Cerrado")
        );
        when(soporteRepository.findAll()).thenReturn(lista);

        List<Soporte> resultado = soporteService.BuscarSoporte();

        assertEquals(2, resultado.size());
        verify(soporteRepository, times(1)).findAll();
    }

    @Test
    void buscarSoportePorId_existente_debeRetornarSoporte() {
        Soporte soporte = new Soporte(1, 100, "Ayuda", "Abierto");
        when(soporteRepository.findById(1)).thenReturn(Optional.of(soporte));

        Soporte resultado = soporteService.buscarSoporteId(1);

        assertNotNull(resultado);
        assertEquals("Ayuda", resultado.getMensaje());
    }

    @Test
    void buscarSoportePorId_noExistente_debeRetornarNull() {
        when(soporteRepository.findById(99)).thenReturn(Optional.empty());

        Soporte resultado = soporteService.buscarSoporteId(99);

        assertNull(resultado);
    }

    @Test
    void guardarSoporte_debeForzarIdACeroYGuardar() {
        Soporte soporte = new Soporte(5, 200, "Error en el sistema", "Pendiente");
        Soporte esperado = new Soporte(0, 200, "Error en el sistema", "Pendiente");

        when(soporteRepository.save(any(Soporte.class))).thenReturn(esperado);

        Soporte resultado = soporteService.guardarSoporte(soporte);

        assertEquals(0, resultado.getIdS());
        assertEquals("Error en el sistema", resultado.getMensaje());
        verify(soporteRepository).save(any(Soporte.class));
    }

    @Test
    void editarSoporte_existente_debeActualizarCamposYGuardar() {
        Soporte existente = new Soporte(1, 300, "Mensaje antiguo", "Pendiente");
        Soporte actualizado = new Soporte(1, 400, "Mensaje nuevo", "Resuelto");

        when(soporteRepository.findById(1)).thenReturn(Optional.of(existente));
        when(soporteRepository.save(any(Soporte.class))).thenReturn(actualizado);

        Soporte resultado = soporteService.editarSoporte(1, actualizado);

        assertNotNull(resultado);
        assertEquals("Mensaje nuevo", resultado.getMensaje());
        assertEquals("Resuelto", resultado.getEstado());
        assertEquals(400, resultado.getUsuarioId());
    }

    @Test
    void editarSoporte_noExistente_debeRetornarNull() {
        Soporte soporte = new Soporte(99, 123, "Mensaje X", "N/A");

        when(soporteRepository.findById(99)).thenReturn(Optional.empty());

        Soporte resultado = soporteService.editarSoporte(99, soporte);

        assertNull(resultado);
    }

    @Test
    void eliminarSoporte_debeLlamarDeletePorId() {
        int id = 10;
        doNothing().when(soporteRepository).deleteById(id);

        soporteService.eliminarSoporte(id);

        verify(soporteRepository, times(1)).deleteById(id);
    }
}

