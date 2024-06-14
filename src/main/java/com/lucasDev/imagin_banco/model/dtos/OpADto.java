package com.lucasDev.imagin_banco.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OpADto {

    private Date fecha;

    private String motivo;

    private String tipo;

    private String estado;

    private double cantidad;

    private BigDecimal balance;

    private TarjetaDto tarjeta;
}
