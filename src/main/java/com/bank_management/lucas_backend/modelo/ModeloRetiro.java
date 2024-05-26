package com.bank_management.lucas_backend.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModeloRetiro {

    private String numTarjeta;

    private String cvv;

    private Double cantidad;
    
}
