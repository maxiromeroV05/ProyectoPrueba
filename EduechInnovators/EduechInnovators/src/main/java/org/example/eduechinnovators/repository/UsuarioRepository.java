package org.example.eduechinnovators.repository;

import org.example.eduechinnovators.model.Curso;
import org.example.eduechinnovators.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioRepository {

    @Autowired
    private JpaUsuarioRepository jpaUsuarioRepository;

    // Obtener todos los usuarios
    public List<Usuario> obtenerUsuarios() {
        return jpaUsuarioRepository.findAll();
    }

    // Guardar un nuevo usuario
    public Usuario guardarUsuario(Usuario usuario) {
        return jpaUsuarioRepository.save(usuario);
    }

    // Buscar un usuario por ID
    public Usuario buscarUsuarioId(int id) {
        return jpaUsuarioRepository.findById(id).orElse(null);
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
            return jpaUsuarioRepository.save(usuarioExistente);
        }
        return null;
    }

    // Eliminar un usuario por ID
    public void eliminarUsuario(int id) {
        jpaUsuarioRepository.deleteById(id);
    }
}
