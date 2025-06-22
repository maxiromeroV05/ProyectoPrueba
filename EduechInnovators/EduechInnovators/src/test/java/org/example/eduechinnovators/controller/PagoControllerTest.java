package org.example.eduechinnovators.controller;

import org.example.eduechinnovators.model.Pago;
import org.example.eduechinnovators.service.PagoService;
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
class PagoControllerTest {

    @Mock
    private PagoService pagoService;

    @InjectMocks
    private PagoController pagoController;

    private Pago pago;

    @BeforeEach
    void setUp() {
        pago = new Pago();
        pago.setId(1);
        // Si Pago tiene más atributos, asigna valores aquí
    }

    @Test
    void crearPago_debeGuardarYRetornarPago() {
        when(pagoService.guardarPago(pago)).thenReturn(pago);

        Pago resultado = pagoController.crearPago(pago);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        verify(pagoService).guardarPago(pago);
    }

    @Test
    void obtenerPagos_debeRetornarListaPagos() {
        when(pagoService.obtenerPagos()).thenReturn(List.of(pago));

        List<Pago> resultado = pagoController.obtenerPagos();

        assertNotNull(resultado);
        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.size());
        verify(pagoService).obtenerPagos();
    }

    @Test
    void obtenerPagoPorId_debeRetornarPago() {
        when(pagoService.obtenerPagoPorId(1)).thenReturn(pago);

        Pago resultado = pagoController.obtenerPagoPorId(1);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        verify(pagoService).obtenerPagoPorId(1);
    }

    @Test
    void eliminarPago_debeLlamarServicioEliminar() {
        when(pagoService.eliminarPago(1)).thenReturn("Pago eliminado");

        pagoController.eliminarPago(1);

        verify(pagoService).eliminarPago(1);
    }
}
