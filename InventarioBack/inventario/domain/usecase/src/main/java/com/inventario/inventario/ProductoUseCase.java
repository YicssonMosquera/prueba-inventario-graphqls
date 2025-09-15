package com.inventario.inventario;

import com.inventario.inventario.producto.Producto;
import com.inventario.inventario.producto.gateway.ProductoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ProductoUseCase {
    private final ProductoRepository repository;

    public Mono<Producto> save(Producto producto){
        return repository.save(producto);
    }

    public Flux<Producto> getAll(){
        return repository.getAll();
    }

    public Mono<Producto>getById(Long id){
        return repository.findById(id);
    }

    public Mono<Boolean>delete(Long id){
        return repository.delete(id);
    }

    public Mono<Producto>update(Long id, Producto producto){
        return repository.update(id,producto);
    }
}
