package com.lucasDev.imagin_banco.mapper;


import com.lucasDev.imagin_banco.model.dtos.TarjetaDto;
import com.lucasDev.imagin_banco.entity.Tarjeta;

public interface TarjetaMapper {

    TarjetaDto toDto(Tarjeta tarjeta);

    Tarjeta toEntity(TarjetaDto tarjetaDto);


}
