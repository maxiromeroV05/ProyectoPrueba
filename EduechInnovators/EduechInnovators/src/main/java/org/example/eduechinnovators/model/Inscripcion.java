package org.example.eduechinnovators.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "INSCRIPCION")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inscripcion_seq")
    @SequenceGenerator(name = "inscripcion_seq", sequenceName = "INSCRIPCION_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private int id;

    @Column(name = "FECHA_INSCRIPCION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInscripcion;

    @Column(name = "ID_CURSO", nullable = false)
    private int idCurso;

    @Column(name = "ID_USUARIO", nullable = false)
    private int idUsuario;

}
