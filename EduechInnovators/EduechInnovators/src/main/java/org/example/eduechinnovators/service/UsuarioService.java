package org.example.eduechinnovators.service;


import org.example.eduechinnovators.model.Usuario;
import org.example.eduechinnovators.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
@Autowired

    private UsuarioRepository usuarioRepository;

    public List<Usuario> buscarUsuarios() {
        return usuarioRepository.obtenerUsuarios();
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.guardarUsuario(usuario);
    }

    public Usuario buscarUsuarioId(int id) {
        return usuarioRepository.buscarUsuarioId(id);
    }

    public Usuario editarUsuario(int id, Usuario usuario) {
        return usuarioRepository.editarUsuario(usuario);
    }

    public void eliminarUsuario(int id) {
        usuarioRepository.eliminarUsuario(id);
    }
}