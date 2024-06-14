package com.lucasDev.imagin_banco.mapper.impl;

import com.lucasDev.imagin_banco.model.dtos.AhorrosDto;
import com.lucasDev.imagin_banco.entity.Ahorros;
import com.lucasDev.imagin_banco.mapper.AhorrosMapper;

public class AhorrosMapperImpl implements AhorrosMapper {

    @Override
    public AhorrosDto toDto(Ahorros ahorros) {
        return AhorrosDto.builder()
                .numCuenta(ahorros.getNumCuenta())
                .balance(ahorros.getBalance())
                .build();
    }

    @Override
    public Ahorros toEntity(AhorrosDto ahorrosDto) {
        return Ahorros.builder()
                .numCuenta(ahorrosDto.getNumCuenta())
                .balance(ahorrosDto.getBalance())
                .build();
    }
}
