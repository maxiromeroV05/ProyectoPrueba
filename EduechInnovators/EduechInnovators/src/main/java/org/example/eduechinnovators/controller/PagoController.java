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

    @PostMapping
    public Pago crearPago(@RequestBody Pago pago) {
        return pagoService.guardarPago(pago);
    }

    @GetMapping
    public List<Pago> obtenerPagos() {
        return pagoService.obtenerPagos();
    }

    @GetMapping("/{id}")
    public Pago obtenerPagoPorId(@PathVariable int id) {
        return pagoService.obtenerPagoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarPago(@PathVariable int id) {
        pagoService.eliminarPago(id);
    }
}
