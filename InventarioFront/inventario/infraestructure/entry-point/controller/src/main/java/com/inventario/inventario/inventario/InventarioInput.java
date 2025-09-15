package com.inventario.inventario.inventario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventarioInput {
    private  Long productoId;
    private  Long bodegaId;
    private  Integer cantidad;
}
