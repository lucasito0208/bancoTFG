package com.lucasDev.imagin_banco.service;

import com.lucasDev.imagin_banco.entity.Tarjeta;
import com.lucasDev.imagin_banco.entity.Ahorros;

import java.security.Principal;



public interface CuentaService {

    Tarjeta createPrimaryAccount();

    Ahorros createSavingsAccount();

    void deposito(String tipo, double cantidad, Principal principal);

    void retiro(String tipo, double cantidad, Principal principal);

}
