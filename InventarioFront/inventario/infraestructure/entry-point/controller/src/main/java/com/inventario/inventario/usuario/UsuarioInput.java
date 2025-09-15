package com.inventario.inventario.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioInput {
    private String nombre;
    private String email;
    private String contrasena;
    private String rol;
}
