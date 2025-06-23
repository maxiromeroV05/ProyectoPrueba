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
    private ContenidoService service;

    @PostMapping
    public Contenido crear(@RequestBody Contenido contenido) {
        return service.guardar(contenido);
    }

    @GetMapping
    public List<Contenido> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Contenido obtener(@PathVariable("id") int idContenido) {
        return service.buscarPorId(idContenido);
    }

    @PutMapping("/{id}")
    public Contenido editar(@PathVariable("id") int idContenido, @RequestBody Contenido nuevoContenido) {
        return service.editar(idContenido, nuevoContenido);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable("id") int idContenido) {
        return service.eliminar(idContenido);
    }
}


