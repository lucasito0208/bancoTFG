package com.lucasDev.imagin_banco.service.UserServiceImpl;

import com.lucasDev.imagin_banco.entity.*;
import com.lucasDev.imagin_banco.model.dtos.*;
import com.lucasDev.imagin_banco.service.OpService;
import com.lucasDev.imagin_banco.repository.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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

    private final ModelMapper mapper;

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

    @Override
    public List<OpADto> listarOperacionesTarjetaDto(String nombreUsuario) {
        UsuarioDto usuario = mapper.map(usuarioRepository.findByNombreUsuario(nombreUsuario), UsuarioDto.class);
        List<OpADto> opADtoList = usuario.getTarjeta().getOpAList();
        return opADtoList;
    }

    public List<OpB> listarOperacionesAhorros(String nombreUsuario) {
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario);
        List<OpB> opBList = usuario.getAhorros().getOpBList();

        return opBList;
    }

    @Override
    public List<OpBDto> listarOperacionesAhorrosDto(String nombreUsuario) {
        UsuarioDto usuario = mapper.map(usuarioRepository.findByNombreUsuario(nombreUsuario), UsuarioDto.class);
        List<OpBDto> opBDtoList = usuario.getAhorros().getOpBList();
        return opBDtoList;
    }

    public void guardarDepositoTarjeta(OpA opA) {
        opARepository.save(opA);
    }

    @Override
    public void guardarDepositoTarjeta(OpADto opADto) {
        opARepository.save(mapper.map(opADto, OpA.class));
    }

    public void guardarDepositoAhorros(OpB opB) {
        opBRepository.save(opB);
    }

    @Override
    public void guardarDepositoAhorros(OpBDto opBDto) {
        opBRepository.save(mapper.map(opBDto, OpB.class));
    }

    public void guardarRetiroTarjeta(OpA opA) {
        opARepository.save(opA);
    }

    @Override
    public void guardarRetiroTarjeta(OpADto opADto) {
        opARepository.save(mapper.map(opADto, OpA.class));
    }

    public void guardarRetiroAhorros(OpB opB) {
        opBRepository.save(opB);
    }

    @Override
    public void guardarRetiroAhorros(OpBDto opBDto) {
        opBRepository.save(mapper.map(opBDto, OpB.class));
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

    @Override
    public void transferirEntreCuentas(String desde, String hasta, String cantidad, TarjetaDto tarjeta, AhorrosDto ahorros) throws Exception {

    }

    public List<Destinatario> listaDestinatarios(Principal principal) {
        String username = principal.getName();
        List<Destinatario> listaDestinatarios = destinatarioRepository.findAll()
                .stream()
                .filter(destinatario -> username.equals(destinatario.getUsuario().getUsername()))
                .collect(Collectors.toList());

        return listaDestinatarios;
    }

    @Override
    public List<DestinatarioDto> listaDestinatariosDto(Principal principal) {
        return null;
    }

    public Destinatario guardarDestinatario(Destinatario destinatario) {
        return destinatarioRepository.save(destinatario);
    }

    @Override
    public DestinatarioDto guardarDestinatario(DestinatarioDto destinatario) {
        return null;
    }

    public Destinatario dameDestinatarioPorNombre(String nombreDestinatario) {
        return destinatarioRepository.findByNombre(nombreDestinatario);
    }

    @Override
    public DestinatarioDto dameDestinatarioDtoPorNombre(String nombreDestinatario) {
        return null;
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

    @Override
    public void transferirDestinatarioDto(DestinatarioDto destinatario, String tipo, String cantidad, TarjetaDto tarjeta, AhorrosDto ahorros) {

    }
}
