package com.bank_management.lucas_backend.service;

import com.bank_management.lucas_backend.modelo.ModeloDeposito;
import com.bank_management.lucas_backend.modelo.ModeloRetiro;
import com.bank_management.lucas_backend.modelo.dto.TransaccionDto;

import java.util.List;

public interface TransaccionServicio {

    List<TransaccionDto> findTransactionList(String nombre);


    
}
