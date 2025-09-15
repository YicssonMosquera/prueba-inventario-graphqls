package com.inventario.inventario.bodega;

import org.springframework.stereotype.Component;

@Component
public class BodegaInputMapper {
    public Bodega toDomain(BodegaDataInput input){
        return new Bodega(null, input.getNombre(),input.getUbicacion());
    }
}
