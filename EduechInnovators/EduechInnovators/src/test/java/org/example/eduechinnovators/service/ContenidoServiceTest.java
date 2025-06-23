package org.example.eduechinnovators.service;

import org.example.eduechinnovators.jparepository.JpaContenidoRepository;
import org.example.eduechinnovators.model.Contenido;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContenidoServiceTest {

    @Mock
    private JpaContenidoRepository repository;

    @InjectMocks
    private ContenidoService service;

    @Test
    void guardarContenido() {
        Contenido contenido = new Contenido(0, "Mate", "Eval 1", "50%", "Foro 1");
        Contenido guardado = new Contenido(1, "Mate", "Eval 1", "50%", "Foro 1");

        when(repository.save(contenido)).thenReturn(guardado);

        Contenido resultado = service.guardar(contenido);

        assertNotNull(resultado);
        assertEquals(1, resultado.getIdC());
        assertEquals("Mate", resultado.getMateria());
    }

    @Test
    void listarContenido() {
        Contenido contenido = new Contenido(1, "Historia", "Eval 2", "80%", "Foro 2");
        when(repository.findAll()).thenReturn(List.of(contenido));

        List<Contenido> lista = service.listar();

        assertEquals(1, lista.size());
        assertEquals("Historia", lista.get(0).getMateria());
    }

    @Test
    void buscarPorId_conResultado() {
        Contenido contenido = new Contenido(2, "Ciencias", "Eval 3", "30%", "Foro 3");
        when(repository.findById(2)).thenReturn(Optional.of(contenido));

        Contenido resultado = service.buscarPorId(2);

        assertNotNull(resultado);
        assertEquals(2, resultado.getIdC());
    }

    @Test
    void buscarPorId_sinResultado() {
        when(repository.findById(99)).thenReturn(Optional.empty());

        Contenido resultado = service.buscarPorId(99);

        assertNull(resultado);
    }

    @Test
    void editarContenido_existente() {
        Contenido existente = new Contenido(3, "Arte", "Eval 1", "60%", "Foro viejo");
        Contenido nuevo = new Contenido(3, "Arte", "Eval 2", "100%", "Foro nuevo");

        when(repository.findById(3)).thenReturn(Optional.of(existente));
        when(repository.save(any(Contenido.class))).thenAnswer(inv -> inv.getArgument(0));

        Contenido resultado = service.editar(3, nuevo);

        assertNotNull(resultado);
        assertEquals("Eval 2", resultado.getEvaluaciones());
        assertEquals("100%", resultado.getProgreso());
        assertEquals("Foro nuevo", resultado.getForos());
    }

    @Test
    void editarContenido_noExistente() {
        Contenido nuevo = new Contenido(4, "Lenguaje", "Eval", "30%", "Foro");

        when(repository.findById(4)).thenReturn(Optional.empty());

        Contenido resultado = service.editar(4, nuevo);

        assertNull(resultado);
    }

    @Test
    void eliminarContenido() {
        int id = 5;

        // No se necesita when() para deleteById, solo verify
        String resultado = service.eliminar(id);

        verify(repository, times(1)).deleteById(id);
        assertEquals("Se eliminó con éxito", resultado);
    }
}

