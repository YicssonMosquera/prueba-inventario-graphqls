package com.inventario.inventario.bodega;

import com.inventario.inventario.BodegaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class BodegaController {
    private final BodegaUseCase bodegaUseCase;
    private final BodegaInputMapper mapperController;

    @QueryMapping
    public Flux<Bodega>bodegas(){
        return bodegaUseCase.getAll();
    }

    @QueryMapping
    public Mono<Bodega>bodegaPorId(@Argument Long id){
        return bodegaUseCase.getById(id);
    }

    @MutationMapping
    public Mono<Bodega>crearBodega(@Argument BodegaDataInput input){
        Bodega bodega = mapperController.toDomain(input);
        return bodegaUseCase.save(bodega);
    }
    @MutationMapping
    public Mono<Boolean> eliminarBodega(@Argument Long id){
        return bodegaUseCase.delete(id);
    }

    @MutationMapping
    public Mono<Bodega> actualizarBodega(@Argument Long id, @Argument BodegaDataInput input) {
        Bodega bodega = mapperController.toDomain(input);
        return bodegaUseCase.update(id, bodega);
    }



}
