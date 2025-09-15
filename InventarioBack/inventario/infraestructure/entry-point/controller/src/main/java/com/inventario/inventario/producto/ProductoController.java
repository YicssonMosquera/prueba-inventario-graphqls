package com.inventario.inventario.producto;

import com.inventario.inventario.ProductoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoUseCase useCase;
    private final ProductoInputMapper mapper;

    @QueryMapping
    public Flux<Producto> productos(){
        return useCase.getAll();
    }

    @QueryMapping
    public Mono<Producto> productoPorId(@Argument Long id){
        return useCase.getById(id);
    }

    @MutationMapping
    public Mono<Producto>crearProducto(@Argument ProductoInput input){
        Producto producto = mapper.toDomain(input);
        return useCase.save(producto);
    }
    @MutationMapping
    public Mono<Boolean> eliminarProducto(@Argument Long id){
        return useCase.delete(id);
    }

    @MutationMapping
    public Mono<Producto> actualizarProducto(@Argument Long id, @Argument ProductoInput input) {
        Producto producto = mapper.toDomain(input);
        return useCase.update(id, producto);
    }
}
