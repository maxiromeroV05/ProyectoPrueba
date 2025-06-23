package org.example.eduechinnovators.repository;

import org.example.eduechinnovators.model.Pago;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PagoRepository {
    private List<Pago> pagos = new ArrayList<>();
    private int idCounter = 1;

    // Obtener todos los pagos
    public List<Pago> obtenerPagos() {
        return pagos;
    }

    // Guardar un nuevo pago
    public Pago guardarPago(Pago pago) {
        pago.setIdP(idCounter++);
        pagos.add(pago);
        return pago;
    }

    // Buscar un pago por ID
    public Pago buscarPago(int id) {
        return pagos.stream()
                .filter(pago -> pago.getIdP() == id)
                .findFirst()
                .orElse(null);
    }

    // Actualizar un pago
    public Pago actualizarPago(Pago pagoActualizado) {
        Pago pagoExistente = buscarPago(pagoActualizado.getIdP());
        if (pagoExistente != null) {
            pagoExistente.setIdP(pagoActualizado.getIdP());
            pagoExistente.setTarjeta(pagoActualizado.getTarjeta());
            pagoExistente.setClave(pagoActualizado.getClave());
            pagoExistente.setEmail(pagoActualizado.getEmail());
        }
        return pagoExistente;
    }

    // Eliminar un pago por ID
    public void eliminar(int id) {
        pagos.removeIf(pago -> pago.getIdP() == id);
    }
}
