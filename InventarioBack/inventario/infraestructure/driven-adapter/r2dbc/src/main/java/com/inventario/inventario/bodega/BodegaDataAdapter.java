package com.inventario.inventario.bodega;

import com.inventario.inventario.bodega.gateway.BodegaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BodegaDataAdapter implements BodegaRepository {
    private final BodegaDataRepository repository;
    private final BodegaDataMapper mapper;


    @Override
    public Mono<Bodega> save(Bodega bodega) {
        BodegaData bodegaData = mapper.getBodegaData(bodega);
        return repository.save(bodegaData)
                .map(mapper::getBodega);
    }

    @Override
    public Flux<Bodega> getAll() {
        return repository.findAll().map(mapper::getBodega);
    }

    @Override
    public Mono<Bodega> findById(Long id) {
        return repository.findById(id)
                .map(mapper::getBodega)
                .switchIfEmpty(Mono.error(new RuntimeException("bodega no encontrada")));
    }

    @Override
    public Mono<Bodega> update(Long id, Bodega bodega) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("bodega no encontrada")))
                .flatMap(bodegaUpdate ->{
                    BodegaData bodegaData = bodegaUpdate.toBuilder().nombre(bodega.getNombre()).ubicacion(bodega.getUbicacion()).build();
                        return repository.save(bodegaData)
                            .map(mapper::getBodega);
                });
    }

    @Override
    public Mono<Boolean> delete(Long id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("bodega no encontrada")))
                .flatMap(bodega -> repository.delete(bodega).thenReturn(true));
    }
}
