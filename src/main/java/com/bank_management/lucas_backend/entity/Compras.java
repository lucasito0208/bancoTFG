package com.bank_management.lucas_backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "compras")
public class Compras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;

    private String resumen;

    private String tipo;

    private String status;

    private double cantidad;

    private BigDecimal cantidadDisponible;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_tarjeta")
    private CuentaTarjeta cuentaTarjeta;




}
