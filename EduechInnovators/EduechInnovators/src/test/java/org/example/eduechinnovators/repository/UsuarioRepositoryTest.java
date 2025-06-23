package org.example.eduechinnovators.repository;

import org.example.eduechinnovators.jparepository.JpaUsuarioRepository;
import org.example.eduechinnovators.model.Usuario;
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
class UsuarioRepositoryTest {

    @Mock
    private JpaUsuarioRepository jpaUsuarioRepository;

    @InjectMocks
    private UsuarioRepository usuarioRepository;

    @Test
    void obtenerUsuarios() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Max");
        when(jpaUsuarioRepository.findAll()).thenReturn(List.of(usuario));

        List<Usuario> resultado = usuarioRepository.obtenerUsuarios();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Max", resultado.get(0).getNombre());
    }

    @Test
    void guardarUsuario() {
        Usuario nuevo = new Usuario();
        nuevo.setNombre("Nuevo");

        Usuario guardado = new Usuario();
        guardado.setIdU(5);
        guardado.setNombre("Nuevo");

        when(jpaUsuarioRepository.save(nuevo)).thenReturn(guardado);

        Usuario resultado = usuarioRepository.guardarUsuario(nuevo);

        assertNotNull(resultado);
        assertEquals(5, resultado.getIdU());
        assertEquals("Nuevo", resultado.getNombre());
    }

    @Test
    void buscarUsuarioId() {
        Usuario usuario = new Usuario();
        usuario.setIdU(1);
        usuario.setNombre("Max");

        when(jpaUsuarioRepository.findById(1)).thenReturn(Optional.of(usuario));

        Usuario resultado = usuarioRepository.buscarUsuarioId(1);

        assertNotNull(resultado);
        assertEquals(1, resultado.getIdU());
        assertEquals("Max", resultado.getNombre());
    }

    @Test
    void editarUsuario() {
        int id = 1;
        Usuario usuarioExistente = new Usuario();
        usuarioExistente.setIdU(id);
        usuarioExistente.setNombre("Max");

        Usuario usuarioEditado = new Usuario();
        usuarioEditado.setIdU(id);
        usuarioEditado.setNombre("Editado");
        usuarioEditado.setApellido("Apellido");
        usuarioEditado.setEmail("email@test.com");
        usuarioEditado.setTelefono(123456789);
        usuarioEditado.setDireccion("Dirección 123");

        when(jpaUsuarioRepository.findById(id)).thenReturn(Optional.of(usuarioExistente));
        when(jpaUsuarioRepository.save(any(Usuario.class))).thenAnswer(i -> i.getArgument(0));

        Usuario resultado = usuarioRepository.editarUsuario(usuarioEditado);

        assertNotNull(resultado);
        assertEquals(id, resultado.getIdU());
        assertEquals("Editado", resultado.getNombre());
        assertEquals("Apellido", resultado.getApellido());
        assertEquals("email@test.com", resultado.getEmail());
        assertEquals(123456789, resultado.getTelefono());
        assertEquals("Dirección 123", resultado.getDireccion());
    }


    @Test
    void editarUsuario_noExiste() {
        Usuario usuarioEditado = new Usuario();
        usuarioEditado.setIdU(99);

        when(jpaUsuarioRepository.findById(99)).thenReturn(Optional.empty());

        Usuario resultado = usuarioRepository.editarUsuario(usuarioEditado);

        assertNull(resultado);
    }

    @Test
    void eliminarUsuario() {
        int id = 1;
        doNothing().when(jpaUsuarioRepository).deleteById(id);

        usuarioRepository.eliminarUsuario(id);

        verify(jpaUsuarioRepository).deleteById(id);
    }
}

