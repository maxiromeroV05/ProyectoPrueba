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
    @Column(name = "ID_I")
    private int idI;

    @Column(name = "FECHA_INSCRIPCION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInscripcion;

    @Column(name = "ID_C", nullable = false)
    private int idC;

    @Column(name = "ID_U", nullable = false)
    private int idU;

}
