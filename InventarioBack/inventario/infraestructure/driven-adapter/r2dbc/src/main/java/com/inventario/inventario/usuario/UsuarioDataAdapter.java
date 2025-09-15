package com.inventario.inventario.usuario;

import com.inventario.inventario.producto.ProductoData;
import com.inventario.inventario.usuario.gateway.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UsuarioDataAdapter implements UsuarioRepository {
    private final UsuarioDataRepository repository;
    private final UsuarioDataMapper mapper;
    @Override
    public Mono<Usuario> save(Usuario usuario) {
        UsuarioData usuarioData = mapper.getUsuarioData(usuario);
        return repository.save(usuarioData)
                .map(mapper::getUsuario);
    }

    @Override
    public Flux<Usuario> getAll() {
        return repository.findAll().map(mapper::getUsuario);
    }

    @Override
    public Mono<Usuario> findById(Long id) {
        return repository.findById(id)
                .map(mapper::getUsuario)
                .switchIfEmpty(Mono.error(new RuntimeException("usuario no encontrado")));
    }

    @Override
    public Mono<Usuario> update(Long id, Usuario usuario) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("usuario no encontrado")))
                .flatMap(usuarioUpdate ->{
                    UsuarioData usuarioData = usuarioUpdate.toBuilder().nombre(usuario.getNombre()).email(usuario.getEmail())
                            .contrasena(usuario.getContrasena()).rol(usuario.getRol()).build();
                    return repository.save(usuarioData)
                            .map(mapper::getUsuario);
                });
    }

    @Override
    public Mono<Boolean> delete(Long id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("usuario no encontrado")))
                .flatMap(usuarioData -> repository.delete(usuarioData).thenReturn(true));
    }
}
