package org.example.eduechinnovators.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {
    private int id;
    private int tarjeta;
    private int clave;
    private String email;

}
