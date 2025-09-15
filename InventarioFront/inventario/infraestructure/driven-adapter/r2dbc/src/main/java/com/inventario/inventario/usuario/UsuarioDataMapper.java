package com.inventario.inventario.usuario;

import org.springframework.stereotype.Component;

@Component
public class UsuarioDataMapper {
    public Usuario getUsuario(UsuarioData usuarioData){
        return new Usuario(usuarioData.getId(),usuarioData.getNombre(),usuarioData.getEmail(),usuarioData.getContrasena(),usuarioData.getRol());
    }

    public UsuarioData getUsuarioData(Usuario usuario){
        return UsuarioData.builder()
                .nombre(usuario.getNombre())
                .email(usuario.getEmail())
                .contrasena(usuario.getContrasena())
                .rol(usuario.getRol()).build();
    }
}
