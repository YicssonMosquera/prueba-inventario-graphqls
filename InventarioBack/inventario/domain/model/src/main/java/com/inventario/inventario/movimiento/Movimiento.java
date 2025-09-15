package com.inventario.inventario.movimiento;

import java.time.LocalDateTime;

public class Movimiento {
    public Long getId() {
        return id;
    }

    public Long getInventarioId() {
        return inventarioId;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public Boolean getModRed() {
        return modRed;
    }

    public Movimiento(Long id, Long inventarioId, String tipo, Integer cantidad, LocalDateTime fecha, Long usuarioId, Boolean modRed) {
        this.id = id;
        this.inventarioId = inventarioId;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.usuarioId = usuarioId;
        this.modRed = modRed;
    }

    private final Long id;
    private final Long inventarioId;
    private final String tipo;
    private final Integer cantidad;
    private final LocalDateTime fecha;
    private final Long usuarioId;
    private final Boolean modRed;

}
