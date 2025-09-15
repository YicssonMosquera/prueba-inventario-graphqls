package com.inventario.inventario.producto;

import org.springframework.stereotype.Component;

@Component
public class ProductoInputMapper {
    public Producto toDomain(ProductoInput input){
        return new Producto(null,input.getNombre(),input.getDescripcion(),input.getCategoria(),input.getStok());
    }
}
