package com.inventario.inventario.inventario;

import com.inventario.inventario.bodega.BodegaData;
import com.inventario.inventario.inventario.gateway.InventarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor

public class InventarioDataAdapter implements InventarioRepository {
    private final InventarioDataRepository repository;
    private final InventarioDataMapper mapper;
    @Override
    public Mono<Inventario> save(Inventario inventario) {
        InventarioData inventarioData = mapper.getInventarioData(inventario);
        return repository.save(inventarioData)
                .map(mapper::getInventario);
    }

    @Override
    public Flux<Inventario> getAll() {
        return repository.findAll().map(mapper::getInventario);
    }

    @Override
    public Mono<Inventario> update(Long id, Inventario inventario) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("redgistro de inventario no encontrado")))
                .flatMap(inventarioUpdate ->{
                    InventarioData inventarioData = inventarioUpdate.toBuilder().productoId(inventario.getProductoId()).bodegaId(inventario.getBodegaId())
                            .cantidad(inventario.getCantidad()).build();
                    return repository.save(inventarioData)
                            .map(mapper::getInventario);
                });

    }

    @Override
    public Mono<Inventario> findById(Long id) {
        return repository.findById(id)
                .map(mapper::getInventario)
                .switchIfEmpty(Mono.error(new RuntimeException("redgistro de inventario no encontrado")));
    }

    @Override
    public Mono<Boolean> delete(Long id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("redgistro de inventario no encontrado")))
                .flatMap(inventarioData -> repository.delete(inventarioData).thenReturn(true));
    }
}
