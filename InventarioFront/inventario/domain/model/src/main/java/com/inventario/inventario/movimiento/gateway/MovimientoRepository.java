package com.inventario.inventario.movimiento.gateway;

import com.inventario.inventario.movimiento.Movimiento;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovimientoRepository {
    Mono<Movimiento> save(Movimiento movimiento);
    Flux<Movimiento> getAll();
    Mono<Movimiento>update(Long id, Movimiento movimiento);
    Mono<Movimiento>findById(Long id);
    Mono<Boolean>delete(Long id);
}
