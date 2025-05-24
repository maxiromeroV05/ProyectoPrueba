package org.example.eduechinnovators.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Soporte {
    private int id;
    private int usuarioId;
    private String mensaje;
    private String estado;
}
