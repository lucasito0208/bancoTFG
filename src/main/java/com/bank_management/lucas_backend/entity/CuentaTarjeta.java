package com.bank_management.lucas_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cuenta_tarjeta")
public class CuentaTarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarjeta;

    @Column(unique = true, nullable = false)
    private String numTarjeta;

    @Column(nullable = false)
    private String cvv;

    @Column(nullable = false)
    private Double saldo;

    @OneToMany(mappedBy = "cuentaTarjeta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Compras> listaCompras;

    
}
