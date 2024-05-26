package com.bank_management.lucas_backend.modelo.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value="UsuarioDto", description = "Objeto de transferencia de datos: Usuario")
public class UsuarioDto {

    private String name;

    private String email;

    private String contacto;

    private String password;
    
}
