package org.example.eduechinnovators.controller;


import org.example.eduechinnovators.model.Pago;
import org.example.eduechinnovators.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    // Crear un nuevo pago
    @PostMapping
    public Pago crearPago(@RequestBody Pago pago) {
        return pagoService.guardarPago(pago);
    }

    // Obtener todos los pagos
    @GetMapping
    public List<Pago> obtenerTodosLosPagos() {
        return pagoService.buscarPagos();
    }

    // Obtener un pago por ID
    @GetMapping("/{id}")
    public Pago obtenerPagoPorId(@PathVariable int id) {
        return pagoService.buscarPagoId(id);
    }

    // Actualizar un pago existente
    @PutMapping("/{id}")
    public Pago editarPago(@PathVariable int id, @RequestBody Pago pago) {
        return pagoService.editarPago(id, pago);
    }

    // Eliminar un pago
    @DeleteMapping("/{id}")
    public void eliminarPago(@PathVariable int id) {
        pagoService.eliminarPago(id);
    }
}
