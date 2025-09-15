package com.inventario.inventario.inventario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Table(name = "inventario")
public class InventarioData {
    @Id
    private  Long id;
    @Column(value = "id_producto")
    private  Long productoId;
    @Column(value = "id_bodega")
    private  Long bodegaId;
    private  Integer cantidad;
}
