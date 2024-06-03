package com.bank_management.lucas_backend.mapper.impl;

import com.bank_management.lucas_backend.entity.CuentaAhorros;
import com.bank_management.lucas_backend.mapper.AhorrosMapper;
import com.bank_management.lucas_backend.modelo.dto.CuentaAhorrosDto;
import com.bank_management.lucas_backend.modelo.dto.CuentaTarjetaDto;

public class AhorrosMapperImpl implements AhorrosMapper {


    @Override
    public CuentaAhorrosDto toDto(CuentaAhorros ahorros) {
        return CuentaAhorrosDto.builder()
                .numCuenta(ahorros.getNumCuenta())
                .balance(ahorros.getBalance())
                .build();
    }

    @Override
    public CuentaAhorros toAhorros(CuentaAhorrosDto ahorrosDto) {
        return CuentaAhorros.builder()
                .numCuenta(ahorrosDto.getNumCuenta())
                .balance(ahorrosDto.getBalance())
                .build();
    }
}
