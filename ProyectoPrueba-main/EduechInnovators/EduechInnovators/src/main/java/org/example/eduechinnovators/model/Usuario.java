package org.example.eduechinnovators.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private int id_usuario;
    private String nombre;
    private String apellido;
    private String email;
    private int telefono;
    private String direccion;

}
