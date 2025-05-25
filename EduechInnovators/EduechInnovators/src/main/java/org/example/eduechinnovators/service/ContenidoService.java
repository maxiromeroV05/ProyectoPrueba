package org.example.eduechinnovators.service;


import org.springframework.stereotype.Service;

import org.example.eduechinnovators.model.Contenido;
import org.example.eduechinnovators.repository.ContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
public class ContenidoService {
    @Autowired
    private ContenidoRepository contenidoRepository;

    public List<Contenido> getContenidos() {
        return contenidoRepository.obtenerContenidos();
    }

    public Contenido saveContenido(Contenido contenido) {
        return contenidoRepository.guardarContenido(contenido);
    }

    public Contenido getContenidoId(int id) {
        return contenidoRepository.buscarContenido(id);
    }

    public Contenido updateContenido(int id, Contenido contenido) {
        return contenidoRepository.actualizarContenido(contenido);
    }

    public String deleteContenido(int id) {
        contenidoRepository.eliminar(id);
        return "Contenido eliminado";
    }
}

