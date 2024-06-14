package com.lucasDev.imagin_banco.model.dtos;

import com.lucasDev.imagin_banco.entity.OpB;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AhorrosDto {

    private int numCuenta;
    private BigDecimal balance;

    private List<OpBDto> opBList;

}
