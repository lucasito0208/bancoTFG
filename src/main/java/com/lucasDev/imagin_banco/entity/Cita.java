package com.lucasDev.imagin_banco.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="cita")
public class Cita {

    @Id
    @Column(name="cita_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private String lugar;
    private String motivo;
    private boolean confirmado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
