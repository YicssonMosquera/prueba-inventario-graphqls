package com.inventario.inventario.inventario;

import org.springframework.stereotype.Component;

@Component
public class InventarioDataMapper {

    public Inventario getInventario(InventarioData inventarioData){
        return new Inventario(inventarioData.getId(),inventarioData.getProductoId(),
                inventarioData.getBodegaId(),inventarioData.getCantidad());
    }

    public InventarioData getInventarioData(Inventario inventario){
        return InventarioData.builder()
                .productoId(inventario.getProductoId())
                .bodegaId(inventario.getBodegaId())
                .cantidad(inventario.getCantidad()).build();
    }
}
