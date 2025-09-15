package com.inventario.inventario;

import com.inventario.inventario.bodega.gateway.BodegaRepository;
import com.inventario.inventario.inventario.gateway.InventarioRepository;
import com.inventario.inventario.movimiento.gateway.MovimientoRepository;
import com.inventario.inventario.producto.gateway.ProductoRepository;
import com.inventario.inventario.usuario.gateway.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public BodegaUseCase bodegaUseCase(BodegaRepository bodegaRepository){
        return new BodegaUseCase(bodegaRepository);
    }

    @Bean
    public InventarioUseCase inventarioUseCase(InventarioRepository inventarioRepository){
        return new InventarioUseCase(inventarioRepository);
    }

    @Bean
    public MovimientoUseCase movimientoUseCase(MovimientoRepository movimientoRepository){
        return new MovimientoUseCase(movimientoRepository);
    }

    @Bean
    public ProductoUseCase productoUseCase(ProductoRepository productoRepository){
        return new ProductoUseCase(productoRepository);
    }

    @Bean
    public UsuarioUseCase usuarioUseCase(UsuarioRepository usuarioRepository){
        return new UsuarioUseCase(usuarioRepository);
    }


}
