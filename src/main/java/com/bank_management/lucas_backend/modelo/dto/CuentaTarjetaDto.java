package com.bank_management.lucas_backend.modelo.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value="CuentaTarjetaDTO", description = "Objeto de transferencia de datos: CuentaTarjeta")
public class CuentaTarjetaDto {

    private String numTarjeta;

    private String cvv;

    private Double saldo;
}
