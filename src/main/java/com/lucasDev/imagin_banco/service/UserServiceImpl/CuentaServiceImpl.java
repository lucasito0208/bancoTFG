package com.lucasDev.imagin_banco.service.UserServiceImpl;

import com.lucasDev.imagin_banco.entity.*;
import com.lucasDev.imagin_banco.repository.TarjetaRepository;
import com.lucasDev.imagin_banco.repository.AhorrosRepository;
import com.lucasDev.imagin_banco.repository.UsuarioRepository;
import com.lucasDev.imagin_banco.service.CuentaService;
import com.lucasDev.imagin_banco.service.OpService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;


@Service
@Builder
@RequiredArgsConstructor
public class CuentaServiceImpl implements CuentaService {

    private final TarjetaRepository tarjetaRepository;

    private final AhorrosRepository ahorrosRepository;

    private final UsuarioRepository usuarioRepository;

    private final OpService opService;

    private final AtomicInteger siguienteNumCuenta = new AtomicInteger(41296801);

    public Tarjeta createPrimaryAccount() {
        Tarjeta tarjeta = Tarjeta.builder()
                .numCuenta(accountGen())
                .balance(new BigDecimal("0.0"))
                .build();

        tarjetaRepository.save(tarjeta);

        return tarjetaRepository.findByNumCuenta(tarjeta.getNumCuenta());
    }

    public Ahorros createSavingsAccount() {
        Ahorros ahorros = Ahorros.builder()
                .numCuenta(accountGen())
                .balance(new BigDecimal("0.0"))
                .build();

        ahorrosRepository.save(ahorros);

        return ahorrosRepository.findByNumCuenta(ahorros.getNumCuenta());
    }

    public void deposito(String tipo, double cantidad, Principal principal) {
        Usuario usuario = usuarioRepository.findByNombreUsuario(principal.getName());

        if (tipo.equalsIgnoreCase("Tarjeta")) {
            Tarjeta tarjeta = usuario.getTarjeta();
            tarjeta.setBalance(tarjeta.getBalance().add(new BigDecimal(cantidad)));
            tarjetaRepository.save(tarjeta);

            Date date = new Date();

            OpA opA = new OpA(date, "Depositar en la cuenta asociada a la tarjeta", "Cuenta", "Completada", cantidad, tarjeta.getBalance(), tarjeta);
            opService.guardarDepositoTarjeta(opA);

        } else if (tipo.equalsIgnoreCase("Ahorros")) {
            Ahorros ahorros = usuario.getAhorros();
            ahorros.setBalance(ahorros.getBalance().add(new BigDecimal(cantidad)));
            ahorrosRepository.save(ahorros);

            Date date = new Date();
            OpB opB = new OpB(date, "Depositar en la cuenta de ahorros", "Cuenta", "Completada", cantidad, ahorros.getBalance(), ahorros);
            opService.guardarDepositoAhorros(opB);
        }
    }

    public void retiro(String tipo, double cantidad, Principal principal) {
        Usuario usuario = usuarioRepository.findByNombreUsuario(principal.getName());

        if (tipo.equalsIgnoreCase("Tarjeta")) {
            Tarjeta tarjeta = usuario.getTarjeta();
            tarjeta.setBalance(tarjeta.getBalance().subtract(new BigDecimal(cantidad)));
            tarjetaRepository.save(tarjeta);

            Date date = new Date();

            OpA opA = new OpA(date, "Retirar de la cuenta asociada a la tarjeta", "Cuenta", "Completada", cantidad, tarjeta.getBalance(), tarjeta);
            opService.guardarRetiroTarjeta(opA);
        } else if (tipo.equalsIgnoreCase("Ahorros")) {
            Ahorros ahorros = usuario.getAhorros();
            ahorros.setBalance(ahorros.getBalance().subtract(new BigDecimal(cantidad)));
            ahorrosRepository.save(ahorros);

            Date date = new Date();
            OpB opB = new OpB(date, "Retirar de la cuenta de ahorros", "Cuenta", "Completada", cantidad, ahorros.getBalance(), ahorros);
            opService.guardarRetiroAhorros(opB);
        }
    }

    private int accountGen() {
        return siguienteNumCuenta.incrementAndGet();
    }


}
