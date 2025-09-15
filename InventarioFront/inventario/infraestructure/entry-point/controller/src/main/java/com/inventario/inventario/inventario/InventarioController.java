package com.inventario.inventario.inventario;

import com.inventario.inventario.InventarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class InventarioController {
    private final InventarioUseCase useCase;
    private final InventarioInputMapper mapper;

    @QueryMapping
    public Flux<Inventario> inventarios(){
        return useCase.getAll();
    }

    @QueryMapping
    public Mono<Inventario> inventarioPorId(@Argument Long id){
        return useCase.getById(id);
    }

    @MutationMapping
    public Mono<Inventario>crearInventario(@Argument InventarioInput input){
        Inventario inventario = mapper.toDomain(input);
        return useCase.save(inventario);
    }
    @MutationMapping
    public Mono<Boolean> eliminarInventario(@Argument Long id){
        return useCase.delete(id);
    }

    @MutationMapping
    public Mono<Inventario> actualizarInventario(@Argument Long id, @Argument InventarioInput input) {
        Inventario inventario = mapper.toDomain(input);
        return useCase.update(id, inventario);
    }
}
