package com.lucasDev.imagin_banco.service.UserServiceImpl;

import com.lucasDev.imagin_banco.entity.*;
import com.lucasDev.imagin_banco.service.OpService;
import com.lucasDev.imagin_banco.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OpServiceImpl implements OpService {

    private final UsuarioRepository usuarioRepository;

    private final OpARepository opARepository;

    private final OpBRepository opBRepository;

    private final TarjetaRepository tarjetaRepository;

    private final AhorrosRepository ahorrosRepository;

    private final DestinatarioRepository destinatarioRepository;


    public List<OpA> listarOperacionesTarjeta(String nombreUsuario) {
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario);
        List<OpA> opAList = usuario.getTarjeta().getOpAList();

        return opAList;
    }

    public List<OpB> listarOperacionesAhorros(String nombreUsuario) {
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario);
        List<OpB> opBList = usuario.getAhorros().getOpBList();

        return opBList;
    }

    public void guardarDepositoTarjeta(OpA opA) {
        opARepository.save(opA);
    }

    public void guardarDepositoAhorros(OpB opB) {
        opBRepository.save(opB);
    }

    public void guardarRetiroTarjeta(OpA opA) {
        opARepository.save(opA);
    }

    public void guardarRetiroAhorros(OpB opB) {
        opBRepository.save(opB);
    }

    public void transferirEntreCuentas(String desde, String hasta, String cantidad, Tarjeta tarjeta, Ahorros ahorros) throws Exception {
        if (desde.equalsIgnoreCase("Tarjeta") && hasta.equalsIgnoreCase("Ahorros")) {
            tarjeta.setBalance(tarjeta.getBalance().subtract(new BigDecimal(cantidad)));
            ahorros.setBalance(ahorros.getBalance().add(new BigDecimal(cantidad)));
            tarjetaRepository.save(tarjeta);
            ahorrosRepository.save(ahorros);

            Date fecha = new Date();

            OpA opA = new OpA(fecha, "Transferencia entre cuentas " + desde + " a la cuenta " + hasta, "Cuenta", "Completada", Double.parseDouble(cantidad), tarjeta.getBalance(), tarjeta);
            opARepository.save(opA);
        } else if (desde.equalsIgnoreCase("Ahorros") && hasta.equalsIgnoreCase("Tarjeta")) {
            tarjeta.setBalance(tarjeta.getBalance().add(new BigDecimal(cantidad)));
            ahorros.setBalance(ahorros.getBalance().subtract(new BigDecimal(cantidad)));
            tarjetaRepository.save(tarjeta);
            ahorrosRepository.save(ahorros);

            Date fecha = new Date();

            OpB opB = new OpB(fecha, "Transferir desde " + desde + " a " + hasta, "Transferencia", "Completada", Double.parseDouble(cantidad), ahorros.getBalance(), ahorros);
            opBRepository.save(opB);
        } else {
            throw new Exception("Error en la trasferencia");
        }
    }

    public List<Destinatario> listaDestinatarios(Principal principal) {
        String username = principal.getName();
        List<Destinatario> listaDestinatarios = destinatarioRepository.findAll()
                .stream()
                .filter(destinatario -> username.equals(destinatario.getUsuario().getUsername()))
                .collect(Collectors.toList());

        return listaDestinatarios;
    }

    public Destinatario guardarDestinatario(Destinatario destinatario) {
        return destinatarioRepository.save(destinatario);
    }

    public Destinatario dameDestinatarioPorNombre(String nombreDestinatario) {
        return destinatarioRepository.findByNombre(nombreDestinatario);
    }

    public void borrarDestinatario(String nombreDestinatario) {
        destinatarioRepository.deleteByNombre(nombreDestinatario);
    }

    public void transferirDestinatario(Destinatario destinatario, String tipo, String cantidad, Tarjeta tarjeta, Ahorros ahorros) {
        if (tipo.equalsIgnoreCase("Tarjeta")) {
            tarjeta.setBalance(tarjeta.getBalance().subtract(new BigDecimal(cantidad)));
            tarjetaRepository.save(tarjeta);

            Date fecha = new Date();

            OpA opA = new OpA(fecha, "Transferir a " + destinatario.getNombre(), "Operación", "Completada", Double.parseDouble(cantidad), tarjeta.getBalance(), tarjeta);
            opARepository.save(opA);
        } else if (tipo.equalsIgnoreCase("Ahorros")) {
            ahorros.setBalance(ahorros.getBalance().subtract(new BigDecimal(cantidad)));
            ahorrosRepository.save(ahorros);

            Date fecha = new Date();

            OpB opB = new OpB(fecha, "Transferir al  " + destinatario.getNombre(), "Operación", "Completada", Double.parseDouble(cantidad), ahorros.getBalance(), ahorros);
            opBRepository.save(opB);
        }
    }
}
