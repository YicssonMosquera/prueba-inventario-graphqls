package com.inventario.inventario.movimiento;

import org.springframework.stereotype.Component;

@Component
public class MovimientoDataMapper {
    public Movimiento getMovimiento(MovimientoData movimientoData){
        return new Movimiento(movimientoData.getId(),movimientoData.getInventarioId(),movimientoData.getTipo()
        ,movimientoData.getCantidad(),movimientoData.getFecha(),movimientoData.getUsuarioId(),movimientoData.getModRed());
    }

    public MovimientoData getMovimientoData(Movimiento movimiento){
        return MovimientoData.builder()
                .inventarioId(movimiento.getInventarioId())
                .tipo(movimiento.getTipo())
                .cantidad(movimiento.getCantidad())
                .fecha(movimiento.getFecha())
                .usuarioId(movimiento.getUsuarioId())
                .modRed(movimiento.getModRed())
                .build();
    }
}
