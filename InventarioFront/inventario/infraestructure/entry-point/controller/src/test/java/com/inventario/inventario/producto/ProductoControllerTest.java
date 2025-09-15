package com.inventario.inventario.producto;

import com.inventario.inventario.ProductoUseCase;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductoControllerTest {
    @InjectMocks
    private ProductoController controller;

    @Mock
    private ProductoUseCase useCase;

    @Mock
    private ProductoInputMapper mapper;

    private Producto producto;
    private ProductoInput input;



    @BeforeEach
    void setup() {
        input = new ProductoInput("Santiago", "santiago@email.com","123","admin");
        producto = new Producto(1L, input.getNombre(), input.getDescripcion(),input.getCategoria(),input.getStok());
    }

    @Test
    void productos() {
        when(useCase.getAll()).thenReturn(Flux.just(producto));
        StepVerifier.create(controller.productos())
                .expectNextMatches(u -> u.getNombre().equals("Santiago"))
                .verifyComplete();
    }

    @Test
    void productoPorId() {
        when(useCase.getById(1L)).thenReturn(Mono.just(producto));
        StepVerifier.create(controller.productoPorId(1L))
                .expectNextMatches(u -> u.getNombre().equals("Santiago"))
                .verifyComplete();
    }

    @Test
    void crearProducto() {
        when(mapper.toDomain(input)).thenReturn(producto);
        when(useCase.save(producto)).thenReturn(Mono.just(producto));
        StepVerifier.create(controller.crearProducto(input))
                .expectNextMatches(u -> u.getId().equals(1L))
                .verifyComplete();
    }

    @Test
    void eliminarProducto() {
        when(useCase.delete(1L)).thenReturn(Mono.just(true));
        StepVerifier.create(controller.eliminarProducto(1L))
                .expectNext(true)
                .verifyComplete();
    }

    @Test
    void actualizarProducto() {
        when(mapper.toDomain(input)).thenReturn(producto);
        when(useCase.update(1L, producto)).thenReturn(Mono.just(producto));
        StepVerifier.create(controller.actualizarProducto(1L, input))
                .expectNextMatches(u -> u.getNombre().equals("Santiago"))
                .verifyComplete();
    }
}