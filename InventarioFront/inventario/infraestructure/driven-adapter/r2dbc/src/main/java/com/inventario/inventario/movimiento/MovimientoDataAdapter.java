package com.inventario.inventario.movimiento;

import com.inventario.inventario.inventario.InventarioData;
import com.inventario.inventario.movimiento.gateway.MovimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MovimientoDataAdapter implements MovimientoRepository {
    private final MovimientoDataRepository repository;
    private final MovimientoDataMapper mapper;
    @Override
    public Mono<Movimiento> save(Movimiento movimiento) {
        MovimientoData movimientoData = mapper.getMovimientoData(movimiento);
        return repository.save(movimientoData)
                .map(mapper::getMovimiento);
    }

    @Override
    public Flux<Movimiento> getAll() {
        return repository.findAll().map(mapper::getMovimiento);
    }

    @Override
    public Mono<Movimiento> update(Long id, Movimiento movimiento) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("redgistro de movimiento no encontrado")))
                .flatMap(movimientoDataUpdate ->{
                    MovimientoData movimientoData = movimientoDataUpdate.toBuilder().inventarioId(movimiento.getInventarioId()).tipo(movimiento.getTipo())
                            .cantidad(movimiento.getCantidad()).fecha(movimiento.getFecha()).usuarioId(movimiento.getUsuarioId()).modRed(movimiento.getModRed()).build();
                    return repository.save(movimientoData)
                            .map(mapper::getMovimiento);
                });
    }

    @Override
    public Mono<Movimiento> findById(Long id) {
        return repository.findById(id)
                .map(mapper::getMovimiento)
                .switchIfEmpty(Mono.error(new RuntimeException("redgistro de movimiento no encontrado")));
    }

    @Override
    public Mono<Boolean> delete(Long id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("redgistro de movimiento no encontrado")))
                .flatMap(movimientoData -> repository.delete(movimientoData).thenReturn(true));
    }
}
