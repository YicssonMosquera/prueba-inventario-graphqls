package com.inventario.inventario.usuario;

import com.inventario.inventario.UsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioUseCase useCase;
    private final UsuarioInputMapper mapper;

    @QueryMapping
    public Flux<Usuario> usuarios(){
        return useCase.getAll();
    }

    @QueryMapping
    public Mono<Usuario> usuarioId(@Argument Long id){
        return useCase.getById(id);
    }

    @MutationMapping
    public Mono<Usuario>registrarUsuario(@Argument UsuarioInput input){
        Usuario usuario = mapper.toDomain(input);
        return useCase.save(usuario);
    }
    @MutationMapping
    public Mono<Boolean> eliminarUsuario(@Argument Long id){
        return useCase.delete(id);
    }

    @MutationMapping
    public Mono<Usuario> actualizarUsuario(@Argument Long id, @Argument UsuarioInput input) {
        Usuario usuario = mapper.toDomain(input);
        return useCase.update(id, usuario);
    }

}
