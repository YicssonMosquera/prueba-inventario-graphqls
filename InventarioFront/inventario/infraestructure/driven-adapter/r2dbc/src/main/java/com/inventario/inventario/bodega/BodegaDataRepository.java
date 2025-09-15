package com.inventario.inventario.bodega;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BodegaDataRepository extends ReactiveCrudRepository<BodegaData, Long> {
}
