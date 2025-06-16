package org.example.eduechinnovators.service;

import org.example.eduechinnovators.model.Soporte;
import org.example.eduechinnovators.repository.JpaSoporteRepository;
import org.example.eduechinnovators.repository.SoporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SoporteService {

    @Autowired
    private JpaSoporteRepository repository;

    public List<Soporte> BuscarSoporte() {
        return repository.findAll();
    }

    public Soporte buscarSoporteId(int id) {
        return repository.findById(id).orElse(null);
    }

    public Soporte guardarSoporte(Soporte soporte) {
        soporte.setId(0); // forzar nuevo ID
        return repository.save(soporte);
    }

    public Soporte editarSoporte(int id, Soporte soporte) {
        Optional<Soporte> existente = repository.findById(id);
        if (existente.isPresent()) {
            Soporte s = existente.get();
            s.setUsuarioId(soporte.getUsuarioId());
            s.setMensaje(soporte.getMensaje());
            s.setEstado(soporte.getEstado());
            return repository.save(s);
        }
        return null;
    }

    public void eliminarSoporte(int id) {
        repository.deleteById(id);
    }
}
