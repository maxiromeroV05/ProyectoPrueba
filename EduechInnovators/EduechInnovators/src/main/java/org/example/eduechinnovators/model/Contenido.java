package org.example.eduechinnovators.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contenido {
    private int id;
    private String materia;
    private String evaluaciones;
    private String progreso ;
    private String foros;

}
