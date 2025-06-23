package org.example.eduechinnovators.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_seq")
    @SequenceGenerator(name = "gen_seq", sequenceName = "GENERIC_SEQ", allocationSize = 1)
    @Column(name = "id_U")
    private int idU;

    private String nombre;
    private String apellido;
    private String email;
    private int telefono;
    private String direccion;
}
