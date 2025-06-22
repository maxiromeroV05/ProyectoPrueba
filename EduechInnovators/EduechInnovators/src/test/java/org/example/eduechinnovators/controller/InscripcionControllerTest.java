package org.example.eduechinnovators.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.eduechinnovators.model.Inscripcion;
import org.example.eduechinnovators.service.InscripcionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class InscripcionControllerTest {

    private MockMvc mockMvc;

    @Mock
    private InscripcionService inscripcionService;

    @InjectMocks
    private InscripcionController inscripcionController;

    private ObjectMapper objectMapper = new ObjectMapper();
    private Inscripcion inscripcionEjemplo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(inscripcionController).build();
        inscripcionEjemplo = new Inscripcion(1, new Date(), 101, 202);
    }

    @Test
    void crearInscripcion_debeRetornarInscripcionCreada() throws Exception {
        when(inscripcionService.guardarInscripcion(any(Inscripcion.class))).thenReturn(inscripcionEjemplo);

        mockMvc.perform(post("/api/v6/inscripciones")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inscripcionEjemplo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(inscripcionEjemplo.getId()));
    }

    @Test
    void listarInscripciones_debeRetornarLista() throws Exception {
        List<Inscripcion> lista = Collections.singletonList(inscripcionEjemplo);
        when(inscripcionService.obtenerTodas()).thenReturn(lista);

        mockMvc.perform(get("/api/v6/inscripciones"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(lista.size()));
    }

    @Test
    void obtenerPorId_debeRetornarInscripcion() throws Exception {
        when(inscripcionService.obtenerPorId(1)).thenReturn(inscripcionEjemplo);

        mockMvc.perform(get("/api/v6/inscripciones/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void actualizarInscripcion_debeRetornarActualizada() throws Exception {
        when(inscripcionService.actualizarInscripcion((int) eq(1), any(Inscripcion.class)))
                .thenReturn(inscripcionEjemplo);

        mockMvc.perform(put("/api/v6/inscripciones/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inscripcionEjemplo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void eliminarInscripcion() throws Exception {
        doNothing().when(inscripcionService).eliminarInscripcion(1);

        mockMvc.perform(delete("/api/v6/inscripciones/1"))
                .andExpect(status().isOk());

        verify(inscripcionService, times(1)).eliminarInscripcion(1);
    }
}





