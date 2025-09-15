package com.inventario.inventario.movimiento;

import com.inventario.inventario.MovimientoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class MovimientoController {
    private final MovimientoUseCase useCase;
    private final MovimientoInputMapper mapper;

    @QueryMapping
    public Flux<Movimiento> movimientos(){
        return useCase.getAll();
    }

    @QueryMapping
    public Mono<Movimiento> movimientoId(@Argument Long id){
        return useCase.getById(id);
    }

    @MutationMapping
    public Mono<Movimiento>registrarMovimiento(@Argument MovimientoInput input){
        Movimiento movimiento = mapper.toDomain(input);
        return useCase.save(movimiento);
    }
    @MutationMapping
    public Mono<Boolean> eliminarMovimiento(@Argument Long id){
        return useCase.delete(id);
    }

    @MutationMapping
    public Mono<Movimiento> actualizarMovimiento(@Argument Long id, @Argument MovimientoInput input) {
        Movimiento movimiento = mapper.toDomain(input);
        return useCase.update(id, movimiento);
    }

}
