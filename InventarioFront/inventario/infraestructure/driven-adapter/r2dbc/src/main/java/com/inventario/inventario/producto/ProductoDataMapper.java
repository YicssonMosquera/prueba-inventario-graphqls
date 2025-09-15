package com.inventario.inventario.producto;

import org.springframework.stereotype.Component;

@Component
public class ProductoDataMapper {
    public Producto getProducto(ProductoData productoData){
        return new Producto(productoData.getId(),productoData.getNombre(),productoData.getDescripcion(),
                productoData.getCategoria(),productoData.getStok());
    }

    public ProductoData getProductoData(Producto producto){
        return ProductoData.builder()
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .categoria(producto.getCategoria())
                .stok(producto.getStok()).build();
    }
}
