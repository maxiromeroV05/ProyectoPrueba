package org.example.eduechinnovators.controller;

import org.example.eduechinnovators.model.Soporte;
import org.example.eduechinnovators.service.SoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v5/soportes")
public class SoporteController {

    @Autowired
    private SoporteService service;

    @GetMapping
    public List<Soporte> listarSporte() {
        return service.BuscarSoporte();
    }

    @GetMapping("/{id}")
    public Soporte obtenerSoporte(@PathVariable int id) {
        return service.buscarSoporteId(id);
    }

    @PostMapping
    public Soporte crearSoporte(@RequestBody Soporte soporte) {
        return service.guardarSoporte(soporte);
    }

    @PutMapping("/{id}")
    public Soporte editarSoporte(@PathVariable int id, @RequestBody Soporte soporte) {
        return service.editarSoporte(id, soporte);
    }

    @DeleteMapping("/{id}")
    public void eliminarSoporte(@PathVariable int id) {
        service.eliminarSoporte(id);
    }
}

