package org.example.eduechinnovators.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
    private String celular;
}
