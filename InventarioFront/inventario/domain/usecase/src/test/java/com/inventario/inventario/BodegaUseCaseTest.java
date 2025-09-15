package com.inventario.inventario;

import com.inventario.inventario.bodega.Bodega;
import com.inventario.inventario.bodega.gateway.BodegaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class BodegaUseCaseTest {
    @InjectMocks
    BodegaUseCase useCase;

    @Mock
    BodegaRepository repository;

    Bodega bodega = new Bodega(null,"bodega","medellin");

    @Test
    void save() {
        when(repository.save(bodega)).thenReturn(Mono.just(bodega));
        useCase.save(bodega)
                .as(StepVerifier::create)
                .assertNext(Assertions::assertNotNull)
                .verifyComplete();
    }

    @Test
    void getAll() {
        when(repository.getAll()).thenReturn(Flux.just(bodega));
        StepVerifier.create(useCase.getAll())
                .assertNext(Assertions::assertNotNull).verifyComplete();
    }

    @Test
    void getById() {
        when(repository.findById(any())).thenReturn(Mono.just(bodega));
        StepVerifier.create(useCase.getById(any()))
                .assertNext(Assertions::assertNotNull)
                .verifyComplete();
    }

    @Test
    void update() {
        when(repository.update(any(),any())).thenReturn(Mono.just(bodega));
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