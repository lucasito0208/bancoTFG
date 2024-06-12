package com.lucasDev.imagin_banco.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitaDto {

    private Date fecha;
    private String lugar;
    private String motivo;
    private boolean confirmado;

    private UsuarioDto usuario;
}
