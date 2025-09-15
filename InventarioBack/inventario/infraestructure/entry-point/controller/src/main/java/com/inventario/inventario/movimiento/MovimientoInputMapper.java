package com.inventario.inventario.movimiento;

import org.springframework.stereotype.Component;

@Component
public class MovimientoInputMapper {
    public Movimiento toDomain(MovimientoInput input){
        return new Movimiento(null,input.getInventarioId(),input.getTipo(),input.getCantidad(),
                input.getFecha(),input.getUsuarioId(),input.getModRed());
    }
}
