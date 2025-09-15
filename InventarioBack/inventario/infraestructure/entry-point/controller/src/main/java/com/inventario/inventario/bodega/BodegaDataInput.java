package com.inventario.inventario.bodega;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BodegaDataInput {
    private String nombre;
    private String ubicacion;
}
