package com.inventario.inventario.bodega;

import org.springframework.stereotype.Component;

@Component
public class BodegaDataMapper {

    public Bodega getBodega(BodegaData bodegaData){
        return new Bodega(bodegaData.getId(),bodegaData.getNombre(),bodegaData.getUbicacion());
    }

    public BodegaData getBodegaData(Bodega bodega){
        return BodegaData.builder()
                .nombre(bodega.getNombre())
                .ubicacion(bodega.getUbicacion()).build();
    }
}
