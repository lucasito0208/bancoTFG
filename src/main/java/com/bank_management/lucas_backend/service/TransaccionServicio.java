package com.bank_management.lucas_backend.service;

import com.bank_management.lucas_backend.modelo.ModeloDeposito;
import com.bank_management.lucas_backend.modelo.ModeloRetiro;
import com.bank_management.lucas_backend.modelo.dto.TransaccionDto;

public interface TransaccionServicio {

    TransaccionDto depositar(ModeloDeposito solicitud);

    TransaccionDto retiro(ModeloRetiro solicitud);

    TransaccionDto dameSaldoActual(Long id);
    
}
