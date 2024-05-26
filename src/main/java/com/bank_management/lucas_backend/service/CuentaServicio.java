package com.bank_management.lucas_backend.service;

import java.util.List;

import com.bank_management.lucas_backend.modelo.dto.CuentaDto;

public interface CuentaServicio {

    CuentaDto crearCuenta();

    List<CuentaDto> listarCuentas();

    
    
}
