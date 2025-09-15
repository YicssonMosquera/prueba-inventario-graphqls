package com.inventario.inventario.movimiento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoInput {
    private  Long inventarioId;
    private  String tipo;
    private  Integer cantidad;
    private LocalDateTime fecha;
    private  Long usuarioId;
    private  Boolean modRed;
}
