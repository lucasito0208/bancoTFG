package com.lucasDev.imagin_banco.service;

import com.lucasDev.imagin_banco.entity.Tarjeta;
import com.lucasDev.imagin_banco.entity.Ahorros;
import com.lucasDev.imagin_banco.model.dtos.AhorrosDto;
import com.lucasDev.imagin_banco.model.dtos.TarjetaDto;

import java.security.Principal;



public interface CuentaService {

    Tarjeta createPrimaryAccount();

    TarjetaDto crearCuentaTarjeta();

    Ahorros createSavingsAccount();

    AhorrosDto crearCuentaAhorros();

    void deposito(String tipo, double cantidad, Principal principal);

    void retiro(String tipo, double cantidad, Principal principal);

}
