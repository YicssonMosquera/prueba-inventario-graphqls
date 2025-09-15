package com.inventario.inventario.usuario;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UsuarioDataRepository extends ReactiveCrudRepository<UsuarioData,Long> {
}
