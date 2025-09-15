package com.inventario.inventario.usuario;

import org.springframework.stereotype.Component;

@Component
public class UsuarioInputMapper {
    public Usuario toDomain(UsuarioInput input){
        return new Usuario(null,input.getNombre(),input.getEmail(),input.getContrasena(),input.getRol());
    }
}
