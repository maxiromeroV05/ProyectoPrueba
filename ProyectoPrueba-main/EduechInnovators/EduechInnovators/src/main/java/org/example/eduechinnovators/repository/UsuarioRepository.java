package org.example.eduechinnovators.repository;

import org.example.eduechinnovators.model.Curso;
import org.example.eduechinnovators.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioRepository {
    private List<Usuario> usuarios = new ArrayList<>();
    private int idCounter = 1;

    // Obtener todos los usuarios
    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    // Guardar un nuevo usuario
    public Usuario guardarUsuario(Usuario usuario) {
        usuario.setId(idCounter++);
        usuarios.add(usuario);
        return usuario;
    }

    // Buscar un usuario por ID
    public Usuario buscarUsuarioId(int id) {
        return usuarios.stream()
                .filter(usuario -> usuario.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Editar un usuario
    public Usuario editarUsuario(Usuario usuarioEditado) {
        Usuario usuarioExistente = buscarUsuarioId(usuarioEditado.getId());
        if (usuarioExistente != null) {
            usuarioExistente.setNombre(usuarioEditado.getNombre());
            usuarioExistente.setApellido(usuarioEditado.getApellido());
            usuarioExistente.setEmail(usuarioEditado.getEmail());
            usuarioExistente.setTelefono(usuarioEditado.getTelefono());
            usuarioExistente.setDireccion(usuarioEditado.getDireccion());
        }
        return usuarioExistente;
    }

    // Eliminar un usuario por ID
    public void eliminarUsuario(int id) {
        usuarios.removeIf(usuario -> usuario.getId() == id);
    }
}
