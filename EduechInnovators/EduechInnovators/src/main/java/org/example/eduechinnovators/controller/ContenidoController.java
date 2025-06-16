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
    public Contenido crear(@RequestBody Contenido c) {
        return service.guardar(c);
    }

    @GetMapping
    public List<Contenido> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Contenido obtener(@PathVariable int id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Contenido editar(@PathVariable int id, @RequestBody Contenido nuevo) {
        return service.editar(id, nuevo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }
}

