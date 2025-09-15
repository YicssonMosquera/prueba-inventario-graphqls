package com.inventario.inventario.usuario;

import com.inventario.inventario.UsuarioUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
    class UsuarioControllerTest {

    @Mock
    private UsuarioUseCase useCase;

    @Mock
    private UsuarioInputMapper mapper;

    @InjectMocks
    private UsuarioController controller;

    private Usuario usuario;
    private UsuarioInput input;

    @BeforeEach
    void setup() {
        input = new UsuarioInput("Santiago", "santiago@email.com","123","admin");
        usuario = new Usuario(1L, input.getNombre(), input.getEmail(),input.getContrasena(),input.getRol());
    }
    @Test
    void usuarios() {
        when(useCase.getAll()).thenReturn(Flux.just(usuario));
        StepVerifier.create(controller.usuarios())
                .expectNextMatches(u -> u.getNombre().equals("Santiago"))
                .verifyComplete();
    }

    @Test
    void usuarioId() {
        when(useCase.getById(1L)).thenReturn(Mono.just(usuario));
        StepVerifier.create(controller.usuarioId(1L))
                .expectNextMatches(u -> u.getEmail().equals("santiago@email.com"))
                .verifyComplete();
    }

    @Test
    void registrarUsuario() {
        when(mapper.toDomain(input)).thenReturn(usuario);
        when(useCase.save(usuario)).thenReturn(Mono.just(usuario));
        StepVerifier.create(controller.registrarUsuario(input))
                .expectNextMatches(u -> u.getId().equals(1L))
                .verifyComplete();
    }

    @Test
    void eliminarUsuario() {
        when(useCase.delete(1L)).thenReturn(Mono.just(true));
        StepVerifier.create(controller.eliminarUsuario(1L))
                .expectNext(true)
                .verifyComplete();
    }

    @Test
    void actualizarUsuario() {
        when(mapper.toDomain(input)).thenReturn(usuario);
        when(useCase.update(1L, usuario)).thenReturn(Mono.just(usuario));
        StepVerifier.create(controller.actualizarUsuario(1L, input))
                .expectNextMatches(u -> u.getNombre().equals("Santiago"))
                .verifyComplete();
    }
}