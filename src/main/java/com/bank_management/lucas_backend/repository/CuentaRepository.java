package com.bank_management.lucas_backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank_management.lucas_backend.entity.Cuenta;
import com.bank_management.lucas_backend.entity.Usuario;

public interface CuentaRepository extends JpaRepository<Cuenta, Long>  {

    List<Cuenta> listarCuentaPorUsuario(Usuario usuario);

    Optional<Cuenta> encontrarPorNumTarjeta(String numTarjeta);

    boolean cuentaExistente(String numTarjeta);





    
}
