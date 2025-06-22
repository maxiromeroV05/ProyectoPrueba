package org.example.eduechinnovators.service;

import org.example.eduechinnovators.jparepository.JpaPagoRepository;
import org.example.eduechinnovators.model.Pago;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PagoServiceTest {

    @Mock
    private JpaPagoRepository pagoRepository;

    @InjectMocks
    private PagoService pagoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarPago_() {
        Pago pago = new Pago(0, 12345678, 123, "correo@ejemplo.com");
        when(pagoRepository.save(pago)).thenReturn(pago);

        Pago resultado = pagoService.guardarPago(pago);

        assertNotNull(resultado);
        assertEquals(12345678, resultado.getTarjeta());
        verify(pagoRepository, times(1)).save(pago);
    }

    @Test
    void obtenerPagos_() {
        List<Pago> lista = Arrays.asList(
                new Pago(1, 1111, 123, "a@a.com"),
                new Pago(2, 2222, 321, "b@b.com")
        );

        when(pagoRepository.findAll()).thenReturn(lista);

        List<Pago> resultado = pagoService.obtenerPagos();

        assertEquals(2, resultado.size());
        verify(pagoRepository, times(1)).findAll();
    }

    @Test
    void obtenerPagoPorId_() {
        Pago pago = new Pago(1, 9999, 000, "test@test.com");
        when(pagoRepository.findById(1)).thenReturn(Optional.of(pago));

        Pago resultado = pagoService.obtenerPagoPorId(1);

        assertNotNull(resultado);
        assertEquals(9999, resultado.getTarjeta());
    }

    @Test
    void obtenerPagoPorId() {
        when(pagoRepository.findById(99)).thenReturn(Optional.empty());

        Pago resultado = pagoService.obtenerPagoPorId(99);

        assertNull(resultado);
    }

    @Test
    void eliminarPago() {
        int id = 1;

        // No es necesario hacer when().thenReturn() con métodos void
        doNothing().when(pagoRepository).deleteById(id);

        String resultado = pagoService.eliminarPago(id);

        assertEquals("Pago removido con exito", resultado);
        verify(pagoRepository, times(1)).deleteById(id);
    }
}

