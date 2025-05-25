package org.example.eduechinnovators.controller;


import org.example.eduechinnovators.model.Usuario;
import org.example.eduechinnovators.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/usuarios")
public class UsuarioController {
    @Autowired

    private UsuarioService usuarioService;

    // crear un usuario
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {return usuarioService.guardarUsuario(usuario);}

    //listar un usuario
    @GetMapping
    public List<Usuario> listarUsuarios() {return usuarioService.buscarUsuarios();}

    // listar por id un usuario
    @GetMapping("/{id}")
    public Usuario obtenerUsuarioPorId(@PathVariable int id) {return usuarioService.buscarUsuarioId(id);}

    // editar un usuario
    @PutMapping("/{id}")
    public Usuario editarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        return usuarioService.editarUsuario( id , usuario);
    }
    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id) {
        usuarioService.eliminarUsuario(id);
    }

}
