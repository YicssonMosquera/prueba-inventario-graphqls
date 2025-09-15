package com.inventario.inventario.inventario.gateway;

import com.inventario.inventario.inventario.Inventario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InventarioRepository {
    Mono<Inventario> save(Inventario inventario);
    Flux<Inventario> getAll();
    Mono<Inventario>update(Long id, Inventario inventario);
    Mono<Inventario>findById(Long id);
    Mono<Boolean>delete(Long id);
}
