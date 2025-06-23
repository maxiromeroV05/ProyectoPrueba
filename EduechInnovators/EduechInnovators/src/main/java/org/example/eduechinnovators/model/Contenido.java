package org.example.eduechinnovators.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CONTENIDO")
public class Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contenido_seq")
    @SequenceGenerator(name = "contenido_seq", sequenceName = "CONTENIDO_SEQ", allocationSize = 1)
    @Column(name = "ID_C")
    private int idC;

    private String materia;
    private String evaluaciones;
    private String progreso;
    private String foros;
}


