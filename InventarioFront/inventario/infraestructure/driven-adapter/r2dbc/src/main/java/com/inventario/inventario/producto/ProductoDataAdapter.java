package com.inventario.inventario.producto;

import com.inventario.inventario.movimiento.MovimientoData;
import com.inventario.inventario.producto.gateway.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductoDataAdapter implements ProductoRepository {
    private final ProductoDataRepository repository;
    private final ProductoDataMapper mapper;
    @Override
    public Mono<Producto> save(Producto producto) {
        ProductoData productoData = mapper.getProductoData(producto);
        return repository.save(productoData)
                .map(mapper::getProducto);
    }

    @Override
    public Flux<Producto> getAll() {
        return repository.findAll().map(mapper::getProducto);
    }

    @Override
    public Mono<Producto> findById(Long id) {
        return repository.findById(id)
                .map(mapper::getProducto)
                .switchIfEmpty(Mono.error(new RuntimeException("producto no encontrado")));
    }

    @Override
    public Mono<Producto> update(Long id, Producto producto) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("producto no encontrado")))
                .flatMap(productoUpdate ->{
                    ProductoData productoData = productoUpdate.toBuilder().nombre(producto.getNombre()).descripcion(producto.getDescripcion())
                            .categoria(producto.getCategoria()).stok(producto.getStok()).build();
                    return repository.save(productoData)
                            .map(mapper::getProducto);
                });
    }

    @Override
    public Mono<Boolean> delete(Long id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("producto no encontrado")))
                .flatMap(productoData -> repository.delete(productoData).thenReturn(true));
    }
}
