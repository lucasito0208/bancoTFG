package com.lucasDev.imagin_banco.mapper;

import com.lucasDev.imagin_banco.model.dtos.AhorrosDto;
import com.lucasDev.imagin_banco.entity.Ahorros;

public interface AhorrosMapper {

    AhorrosDto toDto(Ahorros ahorros);

    Ahorros toEntity(AhorrosDto ahorrosDto);
}
