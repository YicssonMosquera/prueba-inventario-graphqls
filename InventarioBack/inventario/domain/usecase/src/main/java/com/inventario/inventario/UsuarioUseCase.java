package com.inventario.inventario;

import com.inventario.inventario.usuario.Usuario;
import com.inventario.inventario.usuario.gateway.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UsuarioUseCase {
    private final UsuarioRepository repository;

    public Mono<Usuario> save(Usuario usuario){
        return repository.save(usuario);
    }

    public Flux<Usuario> getAll(){
        return repository.getAll();
    }

    public Mono<Usuario>getById(Long id){
        return repository.findById(id);
    }

    public Mono<Boolean>delete(Long id){
        return repository.delete(id);
    }

    public Mono<Usuario>update(Long id, Usuario usuario){
        return repository.update(id,usuario);
    }
}
