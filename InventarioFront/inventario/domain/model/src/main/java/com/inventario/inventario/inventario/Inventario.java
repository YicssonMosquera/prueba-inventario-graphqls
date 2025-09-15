package com.inventario.inventario.inventario;

public class Inventario {
    public Long getId() {
        return id;
    }

    public Long getProductoId() {
        return productoId;
    }

    public Long getBodegaId() {
        return bodegaId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Inventario(Long id, Long productoId, Long bodegaId, Integer cantidad) {
        this.id = id;
        this.productoId = productoId;
        this.bodegaId = bodegaId;
        this.cantidad = cantidad;
    }

    private final Long id;
    private final Long productoId;
    private final Long bodegaId;
    private final Integer cantidad;

}
