package com.bank_management.lucas_backend.modelo;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoRespuesta {

    private HttpStatus status;

    private boolean correcto;

    private Object dato;

    private Object errores;
    
}
