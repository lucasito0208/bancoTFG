package com.bank_management.lucas_backend.modelo.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="TransaccionDTO", description = "Objeto de transferencia de datos: Transaccion")
public class TransaccionDto {

    private Long id;

    private Double cantidad;
    
    private Double saldo;
}
