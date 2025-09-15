package com.inventario.inventario.bodega;

public class Bodega {
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public Bodega(Long id, String nombre, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    private final Long id;
    private final String nombre;
    private final  String ubicacion;

}
