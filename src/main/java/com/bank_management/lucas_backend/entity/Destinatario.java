package com.bank_management.lucas_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "destinatario")
public class Destinatario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDestinatario;

    private String nombre;

    private String email;

    private String contacto;

    private String numCuenta;

    private String resumen;

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnore
    private Usuario usuario;
}
