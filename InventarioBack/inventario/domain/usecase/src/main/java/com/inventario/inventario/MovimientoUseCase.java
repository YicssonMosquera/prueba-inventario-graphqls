package com.inventario.inventario;

import com.inventario.inventario.movimiento.Movimiento;
import com.inventario.inventario.movimiento.gateway.MovimientoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class MovimientoUseCase {
    private final MovimientoRepository repository;

    public Mono<Movimiento> save(Movimiento movimiento){
        return repository.save(movimiento);
    }

    public Flux<Movimiento> getAll(){
        return repository.getAll();
    }

    public Mono<Movimiento>getById(Long id){
        return repository.findById(id);
    }

    public Mono<Boolean>delete(Long id){
        return repository.delete(id);
    }

    public Mono<Movimiento>update(Long id, Movimiento movimiento){
        return repository.update(id,movimiento);
    }
}
