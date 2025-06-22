package org.example.eduechinnovators.controller;

import org.example.eduechinnovators.model.Inscripcion;
import org.example.eduechinnovators.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v6/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    // Crear nueva inscripción
    @PostMapping
    public Inscripcion crearInscripcion(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.guardarInscripcion(inscripcion);
    }

    // Listar todas las inscripciones
    @GetMapping
    public List<Inscripcion> listarInscripciones() {
        return inscripcionService.obtenerTodas();
    }

    // Obtener inscripción por ID
    @GetMapping("/{id}")
    public Inscripcion obtenerPorId(@PathVariable int id) {
        return inscripcionService.obtenerPorId(id);
    }

    // Actualizar inscripción
    @PutMapping("/{id}")
    public Inscripcion actualizarInscripcion(@PathVariable int id, @RequestBody Inscripcion inscripcion) {
        return inscripcionService.actualizarInscripcion(id, inscripcion);
    }

    // Eliminar inscripción
    @DeleteMapping("/{id}")
    public void eliminarInscripcion(@PathVariable int id) {
        inscripcionService.eliminarInscripcion(id);
    }
}


