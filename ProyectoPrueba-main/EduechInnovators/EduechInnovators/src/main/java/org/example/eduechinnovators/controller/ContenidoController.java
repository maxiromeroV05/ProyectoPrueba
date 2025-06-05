package org.example.eduechinnovators.controller;

import org.example.eduechinnovators.model.Contenido;
import org.example.eduechinnovators.service.ContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/contenidos")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @PostMapping
    public Contenido crearContenido(@RequestBody Contenido contenido) {
        return contenidoService.guardarContenido(contenido);
    }

    @GetMapping
    public List<Contenido> obtenerTodosLosContenidos() {
        return contenidoService.buscarContenidos();
    }

    @GetMapping("/{id}")
    public Contenido obtenerContenidoPorId(@PathVariable int id) {
        return contenidoService.buscarContenidoId(id);
    }

    @PutMapping("/{id}")
    public Contenido actualizarContenido(@PathVariable int id, @RequestBody Contenido contenido) {
        return contenidoService.editarContenido(id, contenido);
    }

    @DeleteMapping("/{id}")
    public void eliminarContenido(@PathVariable int id) {
        contenidoService.eliminarContenido(id);
    }
}

