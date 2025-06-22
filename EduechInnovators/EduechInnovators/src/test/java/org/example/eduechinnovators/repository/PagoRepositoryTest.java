package org.example.eduechinnovators.repository;

import org.example.eduechinnovators.model.Pago;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PagoRepositoryTest {

    private PagoRepository pagoRepository;

    @BeforeEach
    void setUp() {
        pagoRepository = new PagoRepository();
    }

    @Test
    void guardarPago_debeAgregarYRetornarPago() {
        Pago pago = new Pago(0, 1234567890, 123, "correo@ejemplo.com");

        Pago resultado = pagoRepository.guardarPago(pago);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        assertEquals(1234567890, resultado.getTarjeta());
    }

    @Test
    void obtenerPagos_debeRetornarListaDePagos() {
        pagoRepository.guardarPago(new Pago(0, 1111222233, 456, "ejemplo@correo.com"));

        List<Pago> lista = pagoRepository.obtenerPagos();

        assertEquals(1, lista.size());
        assertEquals(1111222233, lista.get(0).getTarjeta());
    }

    @Test
    void buscarPago_existente_debeRetornarPago() {
        Pago guardado = pagoRepository.guardarPago(new Pago(0, 444433332, 789, "otro@correo.com"));

        Pago resultado = pagoRepository.buscarPago(guardado.getId());

        assertNotNull(resultado);
        assertEquals("otro@correo.com", resultado.getEmail());
    }

    @Test
    void buscarPago_noExistente_debeRetornarNull() {
        Pago resultado = pagoRepository.buscarPago(999);

        assertNull(resultado);
    }

    @Test
    void actualizarPago_existente_debeActualizarYRetornarPago() {
        // Arrange
        Pago original = pagoRepository.guardarPago(new Pago(0, 0000111122, 321, "antes@correo.com"));
        Pago actualizado = new Pago(original.getId(), 999988887, 000, "nuevo@correo.com");

        // Act
        Pago resultado = pagoRepository.actualizarPago(actualizado);

        // Assert
        assertNotNull(resultado);
        assertEquals(999988887, resultado.getTarjeta());
        assertEquals(000, resultado.getClave());
        assertEquals("nuevo@correo.com", resultado.getEmail());
    }


    @Test
    void actualizarPago_noExistente_debeRetornarNull() {
        Pago inexistente = new Pago(999, 0000000000, 111, "fake@correo.com");

        Pago resultado = pagoRepository.actualizarPago(inexistente);

        assertNull(resultado);
    }

    @Test
    void eliminarPago_existente_debeEliminarPago() {
        Pago guardado = pagoRepository.guardarPago(new Pago(0, 567856785, 555, "delete@correo.com"));

        pagoRepository.eliminar(guardado.getId());

        assertTrue(pagoRepository.obtenerPagos().isEmpty());
    }
}

