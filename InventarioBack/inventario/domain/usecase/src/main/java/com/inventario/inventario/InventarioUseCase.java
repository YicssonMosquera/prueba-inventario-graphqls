package com.inventario.inventario;

import com.inventario.inventario.inventario.Inventario;
import com.inventario.inventario.inventario.gateway.InventarioRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class InventarioUseCase {
    private final InventarioRepository repository;

    public Mono<Inventario> save(Inventario inventario){
        return repository.save(inventario);
    }

    public Flux<Inventario> getAll(){
        return repository.getAll();
    }

    public Mono<Inventario>getById(Long id){
        return repository.findById(id);
    }

    public Mono<Boolean>delete(Long id){
        return repository.delete(id);
    }

    public Mono<Inventario>update(Long id, Inventario inventario){
        return repository.update(id,inventario);
    }
}
