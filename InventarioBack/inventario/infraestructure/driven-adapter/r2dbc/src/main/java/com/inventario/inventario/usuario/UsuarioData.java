package com.inventario.inventario.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Table(name = "usuario")
public class UsuarioData {
    @Id
    private Long id;
    private String nombre;
    private String email;
    private String contrasena;
    private String rol;

}
