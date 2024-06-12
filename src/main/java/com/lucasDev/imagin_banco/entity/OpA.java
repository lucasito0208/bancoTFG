package com.lucasDev.imagin_banco.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="op_a")
public class OpA {

    @Id
    @Column(name="op_a_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;

    private String motivo;

    private String tipo;

    private String estado;

    private double cantidad;

    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "id_tarjeta")
    private Tarjeta tarjeta;

    public OpA(Date fecha, String motivo, String tipo, String estado, double cantidad, BigDecimal balance, Tarjeta tarjeta) {
        this.fecha = fecha;
        this.motivo = motivo;
        this.tipo = tipo;
        this.estado = estado;
        this.cantidad = cantidad;
        this.balance = balance;
        this.tarjeta = tarjeta;
    }
}
