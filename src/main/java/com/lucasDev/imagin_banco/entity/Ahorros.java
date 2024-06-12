package com.lucasDev.imagin_banco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="ahorros")
public class Ahorros {

    @Id
    @Column(name="ahorros_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numCuenta;
    private BigDecimal balance;

    @OneToMany(mappedBy = "ahorros", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<OpB> opBList;



}
