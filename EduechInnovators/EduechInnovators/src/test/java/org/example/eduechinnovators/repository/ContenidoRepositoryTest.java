package org.example.eduechinnovators.repository;

import org.example.eduechinnovators.model.Contenido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContenidoRepositoryTest {

    @Mock
    private ContenidoRepository repository;

    @BeforeEach
    void setUp() {
        // Mockito inyecta el mock automáticamente
    }

    @Test
    void guardarContenido() {
        Contenido contenido = new Contenido(0, "Matemáticas", "Eval 1", "20%", "Foro A");
        Contenido contenidoGuardado = new Contenido(1, "Matemáticas", "Eval 1", "20%", "Foro A");

        when(repository.guardarContenido(contenido)).thenReturn(contenidoGuardado);

        Contenido resultado = repository.guardarContenido(contenido);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        assertEquals("Matemáticas", resultado.getMateria());
        verify(repository, times(1)).guardarContenido(contenido);
    }

    @Test
    void obtenerContenidos() {
        List<Contenido> listaMock = new ArrayList<>();
        listaMock.add(new Contenido(1, "Historia", "Eval 2", "50%", "Foro B"));

        when(repository.obtenerContenidos()).thenReturn(listaMock);

        List<Contenido> lista = repository.obtenerContenidos();

        assertEquals(1, lista.size());
        assertEquals("Historia", lista.get(0).getMateria());
        verify(repository, times(1)).obtenerContenidos();
    }

    @Test
    void buscarContenido_existente() {
        Contenido contenido = new Contenido(1, "Ciencias", "Eval 3", "80%", "Foro C");

        when(repository.buscarContenido(1)).thenReturn(contenido);

        Contenido resultado = repository.buscarContenido(1);

        assertNotNull(resultado);
        assertEquals("Ciencias", resultado.getMateria());
        verify(repository, times(1)).buscarContenido(1);
    }

    @Test
    void buscarContenido_noExistente() {
        when(repository.buscarContenido(999)).thenReturn(null);

        Contenido resultado = repository.buscarContenido(999);

        assertNull(resultado);
        verify(repository, times(1)).buscarContenido(999);
    }

    @Test
    void actualizarContenido_existente() {
        Contenido actualizado = new Contenido(1, "Lenguaje Avanzado", "Eval Final", "100%", "Foro E");

        when(repository.actualizarContenido(actualizado)).thenReturn(actualizado);

        Contenido resultado = repository.actualizarContenido(actualizado);

        assertNotNull(resultado);
        assertEquals("Lenguaje Avanzado", resultado.getMateria());
        assertEquals("Eval Final", resultado.getEvaluaciones());
        assertEquals("100%", resultado.getProgreso());
        assertEquals("Foro E", resultado.getForos());
        verify(repository, times(1)).actualizarContenido(actualizado);
    }

    @Test
    void actualizarContenido_noExistente() {
        Contenido noExistente = new Contenido(999, "Arte", "Eval", "0%", "Foro");

        when(repository.actualizarContenido(noExistente)).thenReturn(null);

        Contenido resultado = repository.actualizarContenido(noExistente);

        assertNull(resultado);
        verify(repository, times(1)).actualizarContenido(noExistente);
    }

    @Test
    void eliminarContenido() {
        doNothing().when(repository).eliminar(1);

        repository.eliminar(1);

        verify(repository, times(1)).eliminar(1);
    }
}

