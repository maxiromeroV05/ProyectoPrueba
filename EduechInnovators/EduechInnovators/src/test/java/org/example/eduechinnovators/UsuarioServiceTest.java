import org.example.eduechinnovators.model.Usuario;
import org.example.eduechinnovators.repository.UsuarioRepository;
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
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void buscarUsuarios_debeRetornarLista() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Max");

        when(usuarioRepository.obtenerUsuarios()).thenReturn(List.of(usuario));

        List<Usuario> resultado = usuarioService.buscarUsuarios();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Max", resultado.get(0).getNombre());
        verify(usuarioRepository).obtenerUsuarios();
    }

    @Test
    void guardarUsuario_debeRetornarUsuarioGuardado() {
        Usuario nuevo = new Usuario();
        nuevo.setNombre("Nuevo");

        Usuario guardado = new Usuario();
        guardado.setId(5);
        guardado.setNombre("Nuevo");

        when(usuarioRepository.guardarUsuario(nuevo)).thenReturn(guardado);

        Usuario resultado = usuarioService.guardarUsuario(nuevo);

        assertNotNull(resultado);
        assertEquals(5, resultado.getId());
        assertEquals("Nuevo", resultado.getNombre());
        verify(usuarioRepository).guardarUsuario(nuevo);
    }

    @Test
    void buscarUsuarioId_debeRetornarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNombre("Max");

        when(usuarioRepository.buscarUsuarioId(1)).thenReturn(usuario);

        Usuario resultado = usuarioService.buscarUsuarioId(1);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        assertEquals("Max", resultado.getNombre());
        verify(usuarioRepository).buscarUsuarioId(1);
    }

    @Test
    void editarUsuario_debeRetornarUsuarioEditado() {
        int id = 1;
        Usuario usuarioEditado = new Usuario();
        usuarioEditado.setId(id);
        usuarioEditado.setNombre("Editado");

        when(usuarioRepository.editarUsuario(usuarioEditado)).thenReturn(usuarioEditado);

        Usuario resultado = usuarioService.editarUsuario(id, usuarioEditado);

        assertNotNull(resultado);
        assertEquals(id, resultado.getId());
        assertEquals("Editado", resultado.getNombre());
        verify(usuarioRepository).editarUsuario(usuarioEditado);
    }

    @Test
    void eliminarUsuario_debeLlamarRepositorioYRetornarMensaje() {
        int id = 1;

        doNothing().when(usuarioRepository).eliminarUsuario(id);

        String mensaje = usuarioService.eliminarUsuario(id);

        verify(usuarioRepository).eliminarUsuario(id);
        assertEquals("Usuario eliminado", mensaje);
    }
}

