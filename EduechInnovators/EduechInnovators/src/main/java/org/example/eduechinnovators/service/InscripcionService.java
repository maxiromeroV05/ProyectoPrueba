package org.example.eduechinnovators.service;

import org.example.eduechinnovators.model.Inscripcion;
import org.example.eduechinnovators.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    // Guardar una nueva inscripcion
    public Inscripcion guardarInscripcion(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    // Obtener todas las inscripciones
    public List<Inscripcion> obtenerTodas() {
        return inscripcionRepository.findAll();
    }

    // Obtener inscripcion por ID
    public Inscripcion obtenerPorId(int id) {
        Optional<Inscripcion> optional = inscripcionRepository.findById(id);
        return optional.orElse(null);
    }

    // Actualizar inscripcion
    public Inscripcion actualizarInscripcion(int id, Inscripcion inscripcionActualizada) {
        Optional<Inscripcion> optional = inscripcionRepository.findById(id);
        if (optional.isPresent()) {
            Inscripcion inscripcionExistente = optional.get();
            inscripcionExistente.setFechaInscripcion(inscripcionActualizada.getFechaInscripcion());
            inscripcionExistente.setIdCurso(inscripcionActualizada.getIdCurso());
            inscripcionExistente.setIdUsuario(inscripcionActualizada.getIdUsuario());
            return inscripcionRepository.save(inscripcionExistente);
        } else {
            return null;
        }
    }

    // Eliminar inscripcion
    public void eliminarInscripcion(int id) {
        inscripcionRepository.deleteById(id);
    }
}

