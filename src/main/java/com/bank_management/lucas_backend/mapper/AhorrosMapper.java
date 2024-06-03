package com.bank_management.lucas_backend.mapper;

import com.bank_management.lucas_backend.entity.CuentaAhorros;
import com.bank_management.lucas_backend.modelo.dto.CuentaAhorrosDto;

public interface AhorrosMapper {

    CuentaAhorrosDto toDto(CuentaAhorros ahorros);

    CuentaAhorros toAhorros(CuentaAhorrosDto ahorrosDto);

}
