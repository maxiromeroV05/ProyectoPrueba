package org.example.eduechinnovators.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    private int id;
    private String nombre;
    private String gestion ;
    private String instructores;
    private boolean evaluar;
}
