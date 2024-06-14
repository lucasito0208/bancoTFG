package com.lucasDev.imagin_banco.service;

import com.lucasDev.imagin_banco.model.ModeloAuthRespuesta;
import com.lucasDev.imagin_banco.model.ModeloPeticionInicioSesion;
import com.lucasDev.imagin_banco.model.ModeloPeticionRegistro;

public interface AuthService {

    ModeloAuthRespuesta registro(ModeloPeticionRegistro request);

    ModeloAuthRespuesta inicio(ModeloPeticionInicioSesion request);

    boolean datosEnUso(String email, String nombreUsuario, String password);


}
