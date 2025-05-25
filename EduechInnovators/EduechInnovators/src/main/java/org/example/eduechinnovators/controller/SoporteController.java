package org.example.eduechinnovators.controller;

import org.example.eduechinnovators.model.Soporte;
import org.example.eduechinnovators.service.SoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/soportes")
public class SoporteController {

    @Autowired
    private SoporteService service;

    @GetMapping
    public List<Soporte> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Soporte obtener(@PathVariable int id) {
        return service.obtener(id);
    }

    @PostMapping
    public Soporte crear(@RequestBody Soporte soporte) {
        return service.crear(soporte);
    }

    @PutMapping("/{id}")
    public Soporte actualizar(@PathVariable int id, @RequestBody Soporte soporte) {
        return service.actualizar(id, soporte);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }
}

