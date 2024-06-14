package com.lucasDev.imagin_banco.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModeloPeticionInicioSesion {


    private String nombreUsuario;


    private String password;
}
