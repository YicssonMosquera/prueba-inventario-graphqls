package com.inventario.inventario.movimiento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Table(name = "movimientos")
public class MovimientoData {
    @Id
    private  Long id;
    @Column(value = "id_inventario")
    private  Long inventarioId;
    private  String tipo;
    private  Integer cantidad;
    private  LocalDateTime fecha;
    @Column(value = "id_usuario")
    private  Long usuarioId;
    private  Boolean modRed;
}
