package com.inventario.inventario.producto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Table(name = "producto")
public class ProductoData {
    @Id
    private  Long id;
    private  String nombre;
    private  String descripcion;
    private  String categoria;
    private  String stok;
}
