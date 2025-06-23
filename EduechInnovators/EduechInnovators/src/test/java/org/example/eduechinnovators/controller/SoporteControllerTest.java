package org.example.eduechinnovators.controller;

import org.example.eduechinnovators.model.Soporte;
import org.example.eduechinnovators.service.SoporteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SoporteControllerTest {

    @Mock
    private SoporteService service;

    @InjectMocks
    private SoporteController controller;

    private Soporte soporte;

    @BeforeEach
    void setUp() {
        soporte = new Soporte();
        soporte.setIdS(1);
        // Asume que Soporte tiene otros atributos, asigna valores si quieres.
    }

    @Test
    void listarSoportes_debeRetornarLista() {
        when(service.BuscarSoporte()).thenReturn(List.of(soporte));

        List<Soporte> resultado = controller.listarSoportes();

        assertNotNull(resultado);
        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.size());
        verify(service).BuscarSoporte();
    }

    @Test
    void obtenerSoporte_debeRetornarSoporte() {
        when(service.buscarSoporteId(1)).thenReturn(soporte);

        Soporte resultado = controller.obtenerSoporte(1);

        assertNotNull(resultado);
        assertEquals(1, resultado.getIdS());
        verify(service).buscarSoporteId(1);
    }

    @Test
    void crearSoporte_debeGuardarYRetornar() {
        when(service.guardarSoporte(soporte)).thenReturn(soporte);

        Soporte resultado = controller.crearSoporte(soporte);

        assertNotNull(resultado);
        verify(service).guardarSoporte(soporte);
    }

    @Test
    void editarSoporte_debeEditarYRetornar() {
        Soporte soporteEditado = new Soporte();
        // Asigna valores al soporte editado si quieres

        when(service.editarSoporte(1, soporteEditado)).thenReturn(soporteEditado);

        Soporte resultado = controller.editarSoporte(1, soporteEditado);

        assertNotNull(resultado);
        verify(service).editarSoporte(1, soporteEditado);
    }

    @Test
    void eliminarSoporte_debeLlamarEliminar() {
        doNothing().when(service).eliminarSoporte(1);

        controller.eliminarSoporte(1);

        verify(service).eliminarSoporte(1);
    }
}

