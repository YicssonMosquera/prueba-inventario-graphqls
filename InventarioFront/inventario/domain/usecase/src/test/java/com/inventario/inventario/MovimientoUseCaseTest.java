package com.inventario.inventario;

import com.inventario.inventario.movimiento.Movimiento;
import com.inventario.inventario.movimiento.gateway.MovimientoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class MovimientoUseCaseTest {
    @InjectMocks
    MovimientoUseCase useCase;

    @Mock
    MovimientoRepository repository;

    Movimiento movimiento = new Movimiento(null, Long.valueOf(2),"prueba",1, LocalDateTime.MAX,Long.valueOf(2),true);

    @Test
    void save() {
        when(repository.save(movimiento)).thenReturn(Mono.just(movimiento));
        useCase.save(movimiento)
                .as(StepVerifier::create)
                .assertNext(Assertions::assertNotNull)
                .verifyComplete();
    }

    @Test
    void getAll() {
        when(repository.getAll()).thenReturn(Flux.just(movimiento));
        StepVerifier.create(useCase.getAll())
                .assertNext(Assertions::assertNotNull).verifyComplete();
    }

    @Test
    void getById() {
        when(repository.findById(any())).thenReturn(Mono.just(movimiento));
        StepVerifier.create(useCase.getById(any()))
                .assertNext(Assertions::assertNotNull)
                .verifyComplete();
    }

    @Test
    void update() {
        when(repository.update(any(),any())).thenReturn(Mono.just(movimiento));
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