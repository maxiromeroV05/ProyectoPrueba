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

    public List<Pago> getPagos() {
        return pagoRepository.obtenerPagos();
    }

    public Pago savePago(Pago pago) {
        return pagoRepository.guardarPago(pago);
    }

    public Pago getPagoId(int id) {
        return pagoRepository.buscarPago(id);
    }

    public Pago updatePago(int id, Pago pago) {
        return pagoRepository.actualizarPago(pago);
    }

    public String deletePago(int id) {
        pagoRepository.eliminar(id);
        return "Pago eliminado";
    }
}
