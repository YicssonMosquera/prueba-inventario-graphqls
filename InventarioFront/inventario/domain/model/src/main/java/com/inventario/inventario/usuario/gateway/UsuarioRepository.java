package com.inventario.inventario.usuario.gateway;

import com.inventario.inventario.producto.Producto;
import com.inventario.inventario.usuario.Usuario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsuarioRepository {
    Mono<Usuario> save(Usuario usuario);
    Flux<Usuario> getAll();
    Mono<Usuario>findById(Long id);
    Mono<Usuario>update(Long id, Usuario usuario);
    Mono<Boolean>delete(Long id);
}
