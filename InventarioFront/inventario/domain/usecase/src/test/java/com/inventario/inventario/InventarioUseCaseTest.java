package com.inventario.inventario;

import com.inventario.inventario.inventario.Inventario;
import com.inventario.inventario.inventario.gateway.InventarioRepository;
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
class InventarioUseCaseTest {
    @InjectMocks
    InventarioUseCase useCase;

    @Mock
    InventarioRepository repository;

    Inventario inventario = new Inventario(null,Long.valueOf(1),Long.valueOf(1),3);

    @Test
    void save() {
        when(repository.save(inventario)).thenReturn(Mono.just(inventario));
        useCase.save(inventario)
                .as(StepVerifier::create)
                .assertNext(Assertions::assertNotNull)
                .verifyComplete();
    }

    @Test
    void getAll() {
        when(repository.getAll()).thenReturn(Flux.just(inventario));
        StepVerifier.create(useCase.getAll())
                .assertNext(Assertions::assertNotNull).verifyComplete();
    }

    @Test
    void getById() {
        when(repository.findById(any())).thenReturn(Mono.just(inventario));
        StepVerifier.create(useCase.getById(any()))
                .assertNext(Assertions::assertNotNull)
                .verifyComplete();
    }

    @Test
    void update() {
        when(repository.update(any(),any())).thenReturn(Mono.just(inventario));
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