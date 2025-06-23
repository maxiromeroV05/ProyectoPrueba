package org.example.eduechinnovators.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CURSO")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_seq")
    @SequenceGenerator(name = "curso_seq", sequenceName = "CURSO_SEQ", allocationSize = 1)
    @Column(name = "ID_CN")
    private int idCN;

    private String nombre;
    private String gestion;
    private String instructores;

    @Column(length = 1)
    private String evaluar;
}
