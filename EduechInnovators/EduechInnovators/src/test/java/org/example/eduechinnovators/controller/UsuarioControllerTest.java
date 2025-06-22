package org.example.eduechinnovators.controller;

import org.example.eduechinnovators.model.Usuario;
import org.example.eduechinnovators.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioControllerTest {

    @Mock
    private UsuarioService service;

    @InjectMocks
    private UsuarioController controller;

    @Test
    void listarUsuarios() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.setNombre("Max");
        when(service.buscarUsuarios()).thenReturn(List.of(usuario));

        // Act
        List<Usuario> resultado = controller.listarUsuarios();

        // Assert
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Max", resultado.get(0).getNombre());
    }

    @Test
    void obtenerUsuarioPorId() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNombre("Max");
        when(service.buscarUsuarioId(1)).thenReturn(usuario);

        // Act
        Usuario resultado = controller.obtenerUsuarioPorId(1);

        // Assert
        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        assertEquals("Max", resultado.getNombre());
    }

    @Test
    void crearUsuario() {
        // Arrange
        Usuario nuevo = new Usuario();
        nuevo.setNombre("Nuevo");

        Usuario guardado = new Usuario();
        guardado.setId(5);
        guardado.setNombre("Nuevo");

        when(service.guardarUsuario(nuevo)).thenReturn(guardado);

        // Act
        Usuario resultado = controller.crearUsuario(nuevo);

        // Assert
        assertNotNull(resultado);
        assertEquals(5, resultado.getId());
        assertEquals("Nuevo", resultado.getNombre());
    }

    @Test
    void editarUsuario() {
        // Arrange
        int id = 1;
        Usuario usuarioEditado = new Usuario();
        usuarioEditado.setNombre("Editado");

        Usuario usuarioResultado = new Usuario();
        usuarioResultado.setId(id);
        usuarioResultado.setNombre("Editado");

        when(service.editarUsuario(id, usuarioEditado)).thenReturn(usuarioResultado);

        // Act
        Usuario resultado = controller.editarUsuario(id, usuarioEditado);

        // Assert
        assertNotNull(resultado);
        assertEquals(id, resultado.getId());
        assertEquals("Editado", resultado.getNombre());
    }

}


