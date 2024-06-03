package com.bank_management.lucas_backend.modelo.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value="CuentaAhorrosDTO", description = "Objeto de transferencia de datos: CuentaAhorros")
public class CuentaAhorrosDto {

    private int numCuenta;

    private BigDecimal balance;
}
