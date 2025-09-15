package com.inventario.inventario;

import com.inventario.inventario.usuario.Usuario;
import com.inventario.inventario.usuario.gateway.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class UsuarioUseCaseTest {
    @InjectMocks
    UsuarioUseCase useCase;

    @Mock
    UsuarioRepository repository;

    Usuario usuario = new Usuario(null,"david","prueba","prueba","prueba");

    @Test
    void save() {
        when(repository.save(usuario)).thenReturn(Mono.just(usuario));
        useCase.save(usuario)
                .as(StepVerifier::create)
                .assertNext(Assertions::assertNotNull)
                .verifyComplete();
    }

    @Test
    void getAll() {
        when(repository.getAll()).thenReturn(Flux.just(usuario));
        StepVerifier.create(useCase.getAll())
                .assertNext(Assertions::assertNotNull).verifyComplete();
    }

    @Test
    void getById() {
        when(repository.findById(any())).thenReturn(Mono.just(usuario));
        StepVerifier.create(useCase.getById(any()))
                .assertNext(Assertions::assertNotNull)
                .verifyComplete();
    }

    @Test
    void update() {
        when(repository.update(any(),any())).thenReturn(Mono.just(usuario));
        StepVerifier.create(useCase.update(any(),any()))
                .assertNext(Assertions::assertNotNull)
                .verifyComplete();
    }

    @Test
    void delete() {
        when(repository.delete(any())).thenReturn(Mono.just(true));
        StepVerifier.create(useCase.delete(any()))
                .assertNext(Assertions::assertTrue)
                .verifyComplete();
    }
}