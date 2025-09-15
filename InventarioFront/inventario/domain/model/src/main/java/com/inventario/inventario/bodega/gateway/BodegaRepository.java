package com.inventario.inventario.bodega.gateway;

import com.inventario.inventario.bodega.Bodega;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BodegaRepository {
    Mono<Bodega>save(Bodega bodega);
    Flux<Bodega>getAll();
    Mono<Bodega>findById(Long id);
    Mono<Bodega>update(Long id, Bodega bodega);
    Mono<Boolean>delete(Long id);
}
