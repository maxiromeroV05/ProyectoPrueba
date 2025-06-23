package org.example.eduechinnovators.controller;

import org.example.eduechinnovators.model.Contenido;
import org.example.eduechinnovators.service.ContenidoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContenidoControllerTest {

    @Mock
    private ContenidoService service;

    @InjectMocks
    private ContenidoController controller;

    @Test
    void crearContenido() {
        // Arrange
        Contenido nuevo = new Contenido(0, "Matemáticas", "Prueba 1", "50%", "Foro 1");
        Contenido guardado = new Contenido(1, "Matemáticas", "Prueba 1", "50%", "Foro 1");

        when(service.guardar(nuevo)).thenReturn(guardado);

        // Act
        Contenido resultado = controller.crear(nuevo);

        // Assert
        assertNotNull(resultado);
        assertEquals(1, resultado.getIdC());
        assertEquals("Matemáticas", resultado.getMateria());
    }

    @Test
    void listarContenidos() {
        // Arrange
        Contenido contenido = new Contenido(1, "Historia", "Prueba 2", "80%", "Foro 2");
        when(service.listar()).thenReturn(List.of(contenido));

        // Act
        List<Contenido> resultado = controller.listar();

        // Assert
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Historia", resultado.get(0).getMateria());
    }

    @Test
    void obtenerContenidoPorId() {
        // Arrange
        Contenido contenido = new Contenido(2, "Ciencias", "Prueba 3", "60%", "Foro 3");
        when(service.buscarPorId(2)).thenReturn(contenido);

        // Act
        Contenido resultado = controller.obtener(2);

        // Assert
        assertNotNull(resultado);
        assertEquals(2, resultado.getIdC());
        assertEquals("Ciencias", resultado.getMateria());
    }

    @Test
    void editarContenido() {
        // Arrange
        int id = 3;
        Contenido actualizado = new Contenido(id, "Lenguaje", "Prueba Final", "100%", "Foro Final");

        when(service.editar(id, actualizado)).thenReturn(actualizado);

        // Act
        Contenido resultado = controller.editar(id, actualizado);

        // Assert
        assertNotNull(resultado);
        assertEquals("Lenguaje", resultado.getMateria());
        assertEquals("100%", resultado.getProgreso());
    }

    @Test
    void eliminarContenido() {
        int id = 1;

        when(service.eliminar(id)).thenReturn("Contenido eliminado");

        controller.eliminar(id);

        verify(service, times(1)).eliminar(id);
    }

}


