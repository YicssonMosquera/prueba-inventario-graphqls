package com.inventario.inventario.producto.gateway;

import com.inventario.inventario.producto.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoRepository {
    Mono<Producto> save(Producto producto);
    Flux<Producto> getAll();
    Mono<Producto>findById(Long id);
    Mono<Producto>update(Long id, Producto producto);
    Mono<Boolean>delete(Long id);
}
