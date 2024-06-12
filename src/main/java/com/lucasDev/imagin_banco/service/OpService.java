package com.lucasDev.imagin_banco.service;

import com.lucasDev.imagin_banco.entity.*;

import java.security.Principal;
import java.util.List;

public interface OpService {

    List<OpA> listarOperacionesTarjeta(String nombreUsuario);

    List<OpB> listarOperacionesAhorros(String nombreUsuario);

    void guardarDepositoTarjeta(OpA opA);

    void guardarDepositoAhorros(OpB opB);

    void guardarRetiroTarjeta(OpA opA);

    void guardarRetiroAhorros(OpB opB);

    void transferirEntreCuentas(String desde, String hasta, String cantidad, Tarjeta tarjeta, Ahorros ahorros) throws Exception;

    List<Destinatario> listaDestinatarios(Principal principal);

    Destinatario guardarDestinatario(Destinatario destinatario);

    Destinatario dameDestinatarioPorNombre(String nombreDestinatario);

    void borrarDestinatario(String nombreDestinatario);

    void transferirDestinatario(Destinatario destinatario, String tipo, String cantidad, Tarjeta tarjeta, Ahorros ahorros);
}
