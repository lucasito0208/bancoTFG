package com.lucasDev.imagin_banco.model.dtos;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class TarjetaDto {

    private int numCuenta;
    private BigDecimal balance;

    private List<OpADto> opAList;
}
