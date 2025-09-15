package com.inventario.inventario.bodega;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Table(name = "bodega")
public class BodegaData {
    @Id
    private Long id;
    private String nombre;
    private String ubicacion;
}
