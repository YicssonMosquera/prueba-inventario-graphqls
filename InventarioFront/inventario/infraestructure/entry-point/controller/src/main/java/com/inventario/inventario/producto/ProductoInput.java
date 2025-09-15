package com.inventario.inventario.producto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoInput {
    private  String nombre;
    private  String descripcion;
    private  String categoria;
    private  String stok;
}
