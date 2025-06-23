package org.example.eduechinnovators.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SOPORTE")
public class Soporte {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_seq")
    @SequenceGenerator(name = "gen_seq", sequenceName = "GENERIC_SEQ", allocationSize = 1)
    @Column(name = "id_S")
    private int idS;

    @Column(name = "USUARIO_ID")
    private int usuarioId;

    private String mensaje;
    private String estado;
}

