package com.bank_management.lucas_backend.mapper.impl;

import org.springframework.stereotype.Component;

import com.bank_management.lucas_backend.entity.Cuenta;
import com.bank_management.lucas_backend.mapper.CuentaMapper;
import com.bank_management.lucas_backend.modelo.dto.CuentaDto;

@Component
public class CuentaMapperImpl implements CuentaMapper{

    @Override
    public CuentaDto toDto(Cuenta cuenta) {
        return CuentaDto
            .builder()
            .numTarjeta(cuenta.getNumTarjeta())
            .cvv(cuenta.getCvv())
            .saldo(cuenta.getSaldo())
            .build();
    }

    
}
