package com.bank_management.lucas_backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String password;

    private String contacto;

    private String email;

    private Rol rol;

    private boolean disponible = true;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Destinatario> listaDestinatarios;

    @OneToOne
    private CuentaTarjeta cuentaTarjeta;

    @OneToOne
    private CuentaAhorros cuentaAhorros;

}
