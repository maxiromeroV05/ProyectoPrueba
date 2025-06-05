package org.example.eduechinnovators.repository;

import org.example.eduechinnovators.model.Soporte;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class SoporteRepository {

    private final Map<Integer, Soporte> almacen = new HashMap<>();
    private final AtomicInteger contadorId = new AtomicInteger(1);

    public List<Soporte> findAll() {
        return new ArrayList<>(almacen.values());
    }

    public Optional<Soporte> findById(int id) {
        return Optional.ofNullable(almacen.get(id));
    }

    public Soporte save(Soporte soporte) {
        if (soporte.getId() == 0) {
            int id = contadorId.getAndIncrement();
            soporte.setId(id);
        }
        almacen.put(soporte.getId(), soporte);
        return soporte;
    }

    public void deleteById(int id) {
        almacen.remove(id);
    }
}

