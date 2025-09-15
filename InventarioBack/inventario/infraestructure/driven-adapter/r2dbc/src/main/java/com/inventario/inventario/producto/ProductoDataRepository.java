package com.inventario.inventario.producto;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductoDataRepository extends ReactiveCrudRepository<ProductoData,Long> {
}
