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
@Table(name="op_b")
public class OpB {


    @Id
    @Column(name="op_b_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private String motivo;
    private String tipo;
    private String estado;
    private double cantidad;
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "id_ahorros")
    private Ahorros ahorros;

    public OpB(Date fecha, String motivo, String tipo, String estado, double cantidad, BigDecimal balance, Ahorros ahorros) {
        this.fecha = fecha;
        this.motivo = motivo;
        this.tipo = tipo;
        this.estado = estado;
        this.cantidad = cantidad;
        this.balance = balance;
        this.ahorros = ahorros;
    }
}
