package com.bank_management.lucas_backend.mapper;

import com.bank_management.lucas_backend.entity.Cuenta;
import com.bank_management.lucas_backend.modelo.dto.CuentaDto;

public interface CuentaMapper {

    CuentaDto toDto(Cuenta cuenta);
    
}
