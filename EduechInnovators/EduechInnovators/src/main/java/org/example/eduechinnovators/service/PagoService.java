package org.example.eduechinnovators.service;

import org.example.eduechinnovators.model.Pago;
import org.example.eduechinnovators.repository.JpaPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PagoService {

    @Autowired
    private JpaPagoRepository pagoRepository;

    public Pago guardarPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public List<Pago> obtenerPagos() {
        return pagoRepository.findAll();
    }

    public Pago obtenerPagoPorId(int id) {
        return pagoRepository.findById(id).orElse(null);
    }

    public String eliminarPago(int id) {
        pagoRepository.deleteById(id);
        return "Pago removido con exito";
    }
}
