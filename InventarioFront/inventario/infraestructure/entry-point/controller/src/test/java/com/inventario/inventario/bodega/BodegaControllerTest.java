package com.inventario.inventario.bodega;

import com.inventario.inventario.BodegaUseCase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BodegaControllerTest {
    @InjectMocks
    private BodegaController controller;
    @Mock
    private BodegaUseCase useCase;

    @Mock
    private BodegaInputMapper mapper;

    private Bodega bodega;
    private BodegaDataInput input;

    @BeforeEach
    void setup() {
      bodega = new Bodega(1L,"prueba","prueba");
      input = new BodegaDataInput("prueba","prueba");
    }


    @Test
    void bodegas() {
        when(useCase.getAll()).thenReturn(Flux.just(bodega));
        StepVerifier.create(controller.bodegas())
                .expectNextMatches(u -> u.getNombre().equals("prueba"))
                .verifyComplete();
    }

    @Test
    void bodegaPorId() {
        when(useCase.getById(1L)).thenReturn(Mono.just(bodega));
        StepVerifier.create(controller.bodegaPorId(1L))
                .expectNextMatches(u -> u.getNombre().equals("prueba"))
                .verifyComplete();
    }

    @Test
    void crearBodega() {
        when(mapper.toDomain(input)).thenReturn(bodega);
        when(useCase.save(bodega)).thenReturn(Mono.just(bodega));
        StepVerifier.create(controller.crearBodega(input))
                .expectNextMatches(u -> u.getId().equals(1L))
                .verifyComplete();

    }

    @Test
    void eliminarBodega() {
        when(useCase.delete(1L)).thenReturn(Mono.just(true));
        StepVerifier.create(controller.eliminarBodega(1L))
                .expectNext(true)
                .verifyComplete();
    }

    @Test
    void actualizarBodega() {
        when(mapper.toDomain(input)).thenReturn(bodega);
        when(useCase.update(1L, bodega)).thenReturn(Mono.just(bodega));
        StepVerifier.create(controller.actualizarBodega(1L, input))
                .expectNextMatches(u -> u.getNombre().equals("prueba"))
                .verifyComplete();
    }
}