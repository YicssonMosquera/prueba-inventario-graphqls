package com.inventario.inventario.inventario;

import org.springframework.stereotype.Component;

@Component
public class InventarioInputMapper {
    public Inventario toDomain(InventarioInput input){
        return new Inventario(null,input.getProductoId(),input.getBodegaId(),input.getCantidad());
    }
}
