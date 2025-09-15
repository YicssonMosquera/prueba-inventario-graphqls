package com.inventario.inventario;

import com.inventario.inventario.bodega.Bodega;
import com.inventario.inventario.bodega.gateway.BodegaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
public class BodegaUseCase {
    private final BodegaRepository repository;

    public Mono<Bodega>save(Bodega bodega){
        return repository.save(bodega);
    }

    public Flux<Bodega>getAll(){
        return repository.getAll();
    }

    public Mono<Bodega>getById(Long id){
        return repository.findById(id);
    }

    public Mono<Bodega>update(Long id, Bodega bodega){
        return repository.update(id,bodega);
    }

    public Mono<Boolean>delete(Long id){
        return repository.delete(id);
    }
}
