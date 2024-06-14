package com.lucasDev.imagin_banco.mapper.impl;

import com.lucasDev.imagin_banco.entity.OpB;
import com.lucasDev.imagin_banco.mapper.AhorrosMapper;
import com.lucasDev.imagin_banco.mapper.OpBMapper;
import com.lucasDev.imagin_banco.model.dtos.OpBDto;

public class OpBMapperImpl implements OpBMapper {

    private AhorrosMapper ahorrosMapper;

    @Override
    public OpBDto toOpBDto(OpB opB) {
        return OpBDto.builder()
                .fecha(opB.getFecha())
                .motivo(opB.getMotivo())
                .tipo(opB.getTipo())
                .estado(opB.getEstado())
                .cantidad(opB.getCantidad())
                .balance(opB.getBalance())
                .ahorros(ahorrosMapper.toDto(opB.getAhorros()))
                .build();
    }

    @Override
    public OpB toOpBEntity(OpBDto opB) {
        return OpB.builder()
                .fecha(opB.getFecha())
                .motivo(opB.getMotivo())
                .tipo(opB.getTipo())
                .estado(opB.getEstado())
                .cantidad(opB.getCantidad())
                .balance(opB.getBalance())
                .ahorros(ahorrosMapper.toEntity(opB.getAhorros()))
                .build();
    }
}
