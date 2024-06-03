package com.bank_management.lucas_backend.service;

import java.security.Principal;
import java.util.List;

import com.bank_management.lucas_backend.entity.TipoTransaccion;
import com.bank_management.lucas_backend.modelo.dto.CuentaAhorrosDto;
import com.bank_management.lucas_backend.modelo.dto.CuentaTarjetaDto;
import org.springframework.stereotype.Service;

@Service
public interface CuentaServicio {

    CuentaTarjetaDto crearTarjeta();

    CuentaAhorrosDto crearAhorros();

    void deposito(String tipoCuenta, double cantidad, Principal principal);

    void retiro(String tipoCuenta, double cantidad, Principal principal);


}
