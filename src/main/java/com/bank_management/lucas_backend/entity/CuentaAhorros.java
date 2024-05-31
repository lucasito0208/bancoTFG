package com.bank_management.lucas_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cuenta_ahorros")
public class CuentaAhorros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAhorros;

    private int numCuenta;

    private BigDecimal balance;

    @OneToMany(mappedBy = "cuentaAhorros", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Transaccion> listaTransacciones;

}
