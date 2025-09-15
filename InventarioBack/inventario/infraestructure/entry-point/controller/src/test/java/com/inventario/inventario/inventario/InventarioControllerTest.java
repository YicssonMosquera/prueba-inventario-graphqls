package com.inventario.inventario.inventario;


import com.inventario.inventario.InventarioUseCase;
import com.inventario.inventario.usuario.Usuario;
import com.inventario.inventario.usuario.UsuarioInput;
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
class InventarioControllerTest {
    @InjectMocks
    private InventarioController controller;

    @Mock
    private InventarioUseCase useCase;

    @Mock
    private InventarioInputMapper mapper;

    private Inventario inventario;
    private InventarioInput input;

    @BeforeEach
    void setup() {
        inventario = new Inventario(1l,2l,1l,2);
        input = new InventarioInput(1l,2l,2);
    }

    @Test
    void inventarios() {
        when(useCase.getAll()).thenReturn(Flux.just(inventario));
        StepVerifier.create(controller.inventarios())
                .expectNextMatches(u -> u.getCantidad().equals(2))
                .verifyComplete();
    }

    @Test
    void inventarioPorId() {
        when(useCase.getById(1L)).thenReturn(Mono.just(inventario));
        StepVerifier.create(controller.inventarioPorId(1L))
                .expectNextMatches(u -> u.getCantidad().equals(2))
                .verifyComplete();
    }

    @Test
    void crearInventario() {
        when(mapper.toDomain(input)).thenReturn(inventario);
        when(useCase.save(inventario)).thenReturn(Mono.just(inventario));
        StepVerifier.create(controller.crearInventario(input))
                .expectNextMatches(u -> u.getId().equals(1L))
                .verifyComplete();
    }

    @Test
    void eliminarInventario() {
        when(useCase.delete(1L)).thenReturn(Mono.just(true));
        StepVerifier.create(controller.eliminarInventario(1L))
                .expectNext(true)
                .verifyComplete();
    }

    @Test
    void actualizarInventario() {
        when(mapper.toDomain(input)).thenReturn(inventario);
        when(useCase.update(1L, inventario)).thenReturn(Mono.just(inventario));
        StepVerifier.create(controller.actualizarInventario(1L, input))
                .expectNextMatches(u -> u.getCantidad().equals(2))
                .verifyComplete();
    }
}