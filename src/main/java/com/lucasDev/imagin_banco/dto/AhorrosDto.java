package com.lucasDev.imagin_banco.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AhorrosDto {

    private int numCuenta;
    private BigDecimal balance;
}
