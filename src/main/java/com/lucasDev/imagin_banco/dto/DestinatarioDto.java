package com.lucasDev.imagin_banco.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DestinatarioDto {

    private String nombre;
    private String email;
    private String contacto;
    private String numCuenta;
    private String resumen;

}
