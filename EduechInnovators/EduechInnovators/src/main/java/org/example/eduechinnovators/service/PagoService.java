package org.example.eduechinnovators.service;

import org.example.eduechinnovators.model.Pago;
import org.example.eduechinnovators.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {
    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> buscarPagos() {
        return pagoRepository.obtenerPagos();
    }

    public Pago guardarPago(Pago pago) {
        return pagoRepository.guardarPago(pago);
    }

    public Pago buscarPagoId(int id) {
        return pagoRepository.buscarPago(id);
    }

    public Pago editarPago(int id, Pago pago) {
        return pagoRepository.actualizarPago(pago);
    }

    public String eliminarPago(int id) {
        pagoRepository.eliminar(id);
        return "Pago eliminado";
    }
}
