package org.example.eduechinnovators.repository;

import org.example.eduechinnovators.jparepository.JpaSoporteRepository;
import org.example.eduechinnovators.model.Soporte;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SoporteRepositoryTest {

    // Simulamos el JpaSoporteRepository
    @Mock
    private JpaSoporteRepository jpaSoporteRepository;

    // Inyectamos el mock dentro del repositorio real
    @InjectMocks
    private SoporteRepository soporteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void debeRetornarTodosLosSoportes() {
        Soporte soporte1 = new Soporte(1, 101, "Error al iniciar sesión", "Abierto");
        Soporte soporte2 = new Soporte(2, 102, "No carga la página", "Resuelto");

        when(jpaSoporteRepository.findAll()).thenReturn(Arrays.asList(soporte1, soporte2));

        List<Soporte> resultado = soporteRepository.findAll();

        assertEquals(2, resultado.size());
        assertEquals("Error al iniciar sesión", resultado.get(0).getMensaje());
        verify(jpaSoporteRepository, times(1)).findAll();
    }

    @Test
    void debeBuscarSoportePorIdExistente() {
        Soporte soporte = new Soporte(1, 103, "Pantalla en blanco", "Pendiente");

        when(jpaSoporteRepository.findById(1)).thenReturn(Optional.of(soporte));

        Optional<Soporte> resultado = soporteRepository.findById(1);

        assertTrue(resultado.isPresent());
        assertEquals("Pantalla en blanco", resultado.get().getMensaje());
        verify(jpaSoporteRepository, times(1)).findById(1);
    }

    @Test
    void debeRetornarVacioSiNoExisteSoporte() {
        when(jpaSoporteRepository.findById(999)).thenReturn(Optional.empty());

        Optional<Soporte> resultado = soporteRepository.findById(999);

        assertFalse(resultado.isPresent());
        verify(jpaSoporteRepository, times(1)).findById(999);
    }

    @Test
    void debeGuardarSoporte() {
        Soporte soporte = new Soporte(0, 104, "Problema con el login", "Abierto");

        when(jpaSoporteRepository.save(soporte)).thenReturn(soporte);

        Soporte resultado = soporteRepository.save(soporte);

        assertNotNull(resultado);
        assertEquals("Problema con el login", resultado.getMensaje());
        verify(jpaSoporteRepository, times(1)).save(soporte);
    }

    @Test
    void debeEliminarSoportePorId() {
        int id = 5;

        doNothing().when(jpaSoporteRepository).deleteById(id);

        soporteRepository.deleteById(id);

        verify(jpaSoporteRepository, times(1)).deleteById(id);
    }
}

