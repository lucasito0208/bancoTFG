package com.lucasDev.imagin_banco.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDto {

    private String nombreUsuario;

    private String password;

    private String nombre;

    private String apellidos;

    private String email;

    private String contacto;

    private boolean disponible = true;

    private TarjetaDto tarjeta;

    private AhorrosDto ahorros;

    private List<CitaDto> citas;

    private List<DestinatarioDto> destinatarioList;



}
