package com.bank_management.lucas_backend.mapper.impl;

import com.bank_management.lucas_backend.entity.CuentaTarjeta;
import com.bank_management.lucas_backend.mapper.TarjetaMapper;
import com.bank_management.lucas_backend.modelo.dto.CuentaTarjetaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class TarjetaMapperImpl implements TarjetaMapper {

    @Override
    public CuentaTarjetaDto toDto(CuentaTarjeta tarjeta) {
        return CuentaTarjetaDto.builder()
                .numTarjeta(tarjeta.getNumTarjeta())
                .cvv(tarjeta.getCvv())
                .saldo(tarjeta.getSaldo())
                .build();
    }

    @Override
    public CuentaTarjeta toTarjeta(CuentaTarjetaDto tarjetaDto) {
        return CuentaTarjeta.builder()
                .numTarjeta(tarjetaDto.getNumTarjeta())
                .cvv(tarjetaDto.getCvv())
                .saldo(tarjetaDto.getSaldo())
                .build();
    }
}
