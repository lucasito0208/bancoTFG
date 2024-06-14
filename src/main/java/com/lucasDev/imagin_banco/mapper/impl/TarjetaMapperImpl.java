package com.lucasDev.imagin_banco.mapper.impl;

import com.lucasDev.imagin_banco.model.dtos.TarjetaDto;
import com.lucasDev.imagin_banco.entity.Tarjeta;
import com.lucasDev.imagin_banco.mapper.TarjetaMapper;

public class TarjetaMapperImpl implements TarjetaMapper {

    @Override
    public TarjetaDto toDto(Tarjeta tarjeta) {
        return TarjetaDto.builder()
                .numCuenta(tarjeta.getNumCuenta())
                .balance(tarjeta.getBalance())
                .build();
    }

    @Override
    public Tarjeta toEntity(TarjetaDto tarjetaDto) {
        return Tarjeta.builder()
                .numCuenta(tarjetaDto.getNumCuenta())
                .balance(tarjetaDto.getBalance())
                .build();
    }
}
