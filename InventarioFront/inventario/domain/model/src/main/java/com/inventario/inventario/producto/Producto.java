package com.inventario.inventario.producto;

public class Producto {
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getStok() {
        return stok;
    }

    public Producto(Long id, String nombre, String descripcion, String categoria, String stok) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.stok = stok;
    }

    private final Long id;
    private final String nombre;
    private final String descripcion;
    private final String categoria;
    private final String stok;

}
