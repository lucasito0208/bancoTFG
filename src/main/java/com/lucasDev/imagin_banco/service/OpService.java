package com.lucasDev.imagin_banco.service;

import com.lucasDev.imagin_banco.entity.*;
import com.lucasDev.imagin_banco.model.dtos.*;

import java.security.Principal;
import java.util.List;

public interface OpService {

    List<OpA> listarOperacionesTarjeta(String nombreUsuario);
    List<OpADto> listarOperacionesTarjetaDto(String nombreUsuario);

    List<OpB> listarOperacionesAhorros(String nombreUsuario);
    List<OpBDto> listarOperacionesAhorrosDto(String nombreUsuario);

    void guardarDepositoTarjeta(OpA opA);
    void guardarDepositoTarjeta(OpADto opA);

    void guardarDepositoAhorros(OpB opB);
    void guardarDepositoAhorros(OpBDto opB);

    void guardarRetiroTarjeta(OpA opA);
    void guardarRetiroTarjeta(OpADto opA);

    void guardarRetiroAhorros(OpB opB);
    void guardarRetiroAhorros(OpBDto opB);

    void transferirEntreCuentas(String desde, String hasta, String cantidad, Tarjeta tarjeta, Ahorros ahorros) throws Exception;
    void transferirEntreCuentas(String desde, String hasta, String cantidad, TarjetaDto tarjeta, AhorrosDto ahorros) throws Exception;

    List<Destinatario> listaDestinatarios(Principal principal);
    List<DestinatarioDto> listaDestinatariosDto(Principal principal);

    Destinatario guardarDestinatario(Destinatario destinatario);
    DestinatarioDto guardarDestinatario(DestinatarioDto destinatario);

    Destinatario dameDestinatarioPorNombre(String nombreDestinatario);
    DestinatarioDto dameDestinatarioDtoPorNombre(String nombreDestinatario);

    void borrarDestinatario(String nombreDestinatario);

    void transferirDestinatario(Destinatario destinatario, String tipo, String cantidad, Tarjeta tarjeta, Ahorros ahorros);
    void transferirDestinatarioDto(DestinatarioDto destinatario, String tipo, String cantidad, TarjetaDto tarjeta, AhorrosDto ahorros);

}
