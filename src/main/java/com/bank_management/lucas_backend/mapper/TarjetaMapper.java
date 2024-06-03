package com.bank_management.lucas_backend.mapper;

import com.bank_management.lucas_backend.entity.CuentaTarjeta;
import com.bank_management.lucas_backend.entity.Usuario;
import com.bank_management.lucas_backend.modelo.dto.CuentaTarjetaDto;
import com.bank_management.lucas_backend.modelo.dto.UsuarioDto;

public interface TarjetaMapper {

    CuentaTarjetaDto toDto(CuentaTarjeta tarjeta);

    CuentaTarjeta toTarjeta(CuentaTarjetaDto tarjetaDto);

}
